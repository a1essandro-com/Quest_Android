package com.example.quest;

public class FinalRoom extends Scene{
    int num;
    String intro;
    String options;
    public void win(){
        num=1;
        options="Победа!";
        intro="Ты забегаешь в залитое светом помещение \n" +
                "Замечаешь разрушенный потолок и останки корабля твоего командира \n" +
                "Среди них ты находишь остатки топлива \n" +
                "Этого должно хватить! \n" +
                "Время выбираться отсюда";
    }
    public void loss(){
        num=1;
        intro="Дойдя до темных частей зала, тебя охватывает дрожь по всему телу \n" +
                "В этой бездне точно что-то скрывается и оно будто движется к тебе \n" +
                "Ты пытаешься бежать обратно, хотя это уже не имеет значения \n" +
                "Ты понимаешь, что это конец";
        options="Увы вы проиграли";
    }
}
