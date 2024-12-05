package org.example.larik.javamasterbot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.Webhook;
@Configuration// Анотация котора создает бин нашего класса
public class Bot extends TelegramLongPollingBot { //Объект ..s Bot  создаст сам спринг


    public Bot() String botToken) { // будем принимать токен нашего бота тут находитьсяс бин
        super(botToken);
    }

    @Override // все что мы будем писать боту, будет приходить сюда
    public void onUpdateReceived(Update update) { //  обязательные два метода которые нам нужно реализовать  onUpdateReceived, getBotUsername
        String MessageText = update.getMessage().getText(); // Создаем объект нашего текста который отправил пользователь
        String name = update.getMessage().getFrom().getUserName(); //Создаем объект(Коробочку) для записывания нашего имени пользователя в тг
        Long Id = update.getMessage().getChatId(); // берем id нашего пользователя в тг

        System.out.println("ChatId " + Id);
        System.out.println("Name" + name );
        System.out.println("Message" + MessageText );



    }

    @Override
    public String getBotUsername() {
        return "JavaMaster1_bot";
    }
}
