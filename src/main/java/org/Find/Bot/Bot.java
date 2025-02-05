package org.Find.Bot;

import lombok.*;
import org.Find.Entity.Vacancy;
import org.Find.services.VacancyService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.Find.Entity.Vacancy;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {
    VacancyService vacancyService = new VacancyService();
    List<Vacancy> vacancies= vacancyService.get5ByVacancyName("Профессия");
    public static int count = 0;

    @Setter
    @Getter
    String userName;
    @Setter
    @Getter
    String token;
    public Bot (String BOT_NAME, String BOT_TOKEN) throws TelegramApiException {
        this.userName = BOT_NAME;
        this.token = BOT_TOKEN;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String answer = update.getMessage().getText();
            String[] separatedAnswer = answer.split(" ");
            String action = separatedAnswer[0];

            switch (action){
                case "/start":
                case "/начало":
                    sendMessage("Привет.Я FindJob221_bot", chatId);
                    break;
                case "/help":
                case "/помощь":
                    sendMessage("Напишите... и выведу список вакансий", chatId);
                    break;
                default:
                    // Отправка 3 сообщений с предложениями по написанному слову
                    getAndSendVacancies(answer,chatId);

                    // Создаем кнопку для повторного запуска
                    sendInlineKeyboard(chatId, answer);
                    break;
            }

        }
    }
    public void getAndSendVacancies(String word, long chatId){
        for (int i=0; i<3;i++){
            if (count <= vacancies.size()){
                Vacancy vacancy = vacancies.get((int)count);
                sendMessage("Вакансия:" + vacancy.getVacancyName() + "[Click here]("+ vacancy.getURL().toString() + ")", chatId);
                count++;
            }
        }

    }

    void sendMessage (String text, long chatId){
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(text);
        message.setParseMode("Markdown");
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            System.out.println("Сообщение не отправлено");;
        }
    }

    private void sendInlineKeyboard(long chatId, String word) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Найти ещё");

        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        // Создаем кнопку
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Повторить");
        button.setCallbackData("repeat_" + word);

        List<InlineKeyboardButton> keyboardButtons = new ArrayList<>();
        keyboardButtons.add(button);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtons);

        markupInline.setKeyboard(rowList);
        message.setReplyMarkup(markupInline);

        try {
            execute(message);  // Отправляем сообщение с кнопкой
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void onWebhookUpdateReceived(org.telegram.telegrambots.meta.api.objects.Update update) {

        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();
            if (callbackData.startsWith("repeat_")) {
                String word = callbackData.substring(7);  // Получаем слово из callbackData
                long chatId = update.getCallbackQuery().getMessage().getChatId();

                // Повторно отправляем 3 сообщения с предложениями
                getAndSendVacancies(word,chatId);

                // Создаем кнопку для повторного запуска
                sendInlineKeyboard(chatId, word);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
