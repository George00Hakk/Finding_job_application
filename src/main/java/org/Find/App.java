package org.Find;

import lombok.var;
import org.Find.Bot.Bot;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws TelegramApiException {
        //через ${} не получилось вставит токен и имя бота из application.properties
       Bot bot = new Bot("FindJob221_bot", "7513291361:AAEdZsrGw3FpfCr7G0W7DZ-2Jr1PDg0rgto") ;
       System.out.println("Все работает!");
    }
}
