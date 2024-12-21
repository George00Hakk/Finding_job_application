package org.Find.Bot;

import lombok.*;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class Bot extends TelegramLongPollingBot {

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
                    sendMessage("Я Вас не понимаю", chatId);
                    break;
            }
        }
    }

    void sendMessage (String text, long chatId){
        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message); // Call method to send the message
        } catch (TelegramApiException e) {
            System.out.println("Сообщение не отправлено");;
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
