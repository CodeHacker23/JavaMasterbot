package org.example.larik.javamasterbot.config;

import org.example.larik.javamasterbot.bot.Bot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration //  класс будет создан спрингом и вызван спрингом
public class BeanConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(Bot bot){  // Возвращает нам объект telegramBotsApi
        try {
            TelegramBotsApi telegramBotsApi
                    = new TelegramBotsApi(DefaultBotSession.class); // объект нашего бота
            telegramBotsApi.registerBot(bot);
            return telegramBotsApi; // возвращать его здесь иначе снизу у него видимости не будет  от проги
        } catch (TelegramApiException e) {
            throw new RuntimeException(e); // создаем Try-cath
        }

    }

}

//метод создает нашего TelegramBotsApi и регистрирует нашего бота.
