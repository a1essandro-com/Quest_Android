package com.example.quest;

public class DangerRoom extends Scene{
    int num;
    String intro;
    String options;
    public void setData(boolean hasKey){
        if (hasKey==true){
            intro="Недолго думая ты достаешь ключ найденный ранее \n" +
                    "Замок со скрипом поддается \n" +
                    "Дверь открывается ...";
            num=1;
            options="Доступные действия: \n" +
                    "1-Пройти внутрь";
        }
        else{
            num=1;
            intro="Ты подошел к двери справа. На ней висит замок \n" +
                    "Найти бы ключ... \n" +
                    "Возможно надо осмотреть другие помещения";
            options="Доступные действия: \n" +
                    "1-Вернуться в центр зала";
        }
    }
    public int setProgress(boolean hasKey){
        if (!hasKey) return 1;
        else return 4;
    }
}
