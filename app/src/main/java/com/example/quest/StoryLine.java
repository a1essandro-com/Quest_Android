package com.example.quest;

public class StoryLine {
    public String currentIntro;
    public String currentOptions;
    public int currentNum;
    public boolean isDead=false;
    Player player = new Player(0);
    public void update(int currentOption){
        ShipRoom shipRoom=new ShipRoom();
        TempleRoom templeRoom=new TempleRoom();
        LivingRoom livingRoom=new LivingRoom();
        DangerRoom dangerRoom= new DangerRoom();
        QuestRoom questRoom = new QuestRoom();
        FinalRoom finalRoom=new FinalRoom();
        switch(player.progress){
            case 0:
                isDead=false;
                currentIntro=shipRoom.intro;
                currentOptions=shipRoom.options;
                currentNum=shipRoom.num;
                //changeCurrentData(shipRoom);
                player.progress++;
                break;
            case 1:
                currentIntro=templeRoom.intro;
                currentOptions=templeRoom.options;
                currentNum=templeRoom.num;
                player.progress++;
                break;
            case 2:
                if (currentOption==0){
                    player.progress=0;
                    update(0);
                }
                else if (currentOption==1){
                    currentIntro= livingRoom.intro;
                    currentOptions=livingRoom.options;
                    currentNum=livingRoom.num;
                    player.progress++;
                }
                else if(currentOption==2){
                    dangerRoom.setData(player.hasKey);
                    currentIntro=dangerRoom.intro;
                    currentOptions=dangerRoom.options;
                    currentNum=dangerRoom.num;
                    player.progress=dangerRoom.setProgress(player.hasKey);
                }
                break;
            case 3:
                if(currentOption==0){
                    player.progress=1;
                    update(0);
                }
                else if(currentOption==1){
                    livingRoom.changeData();
                    currentIntro= livingRoom.intro;
                    currentOptions=livingRoom.options;
                    currentNum=livingRoom.num;
                    player.progress=1;
                    player.hasKey=true;
                }
                break;
            case 4:
                currentIntro= questRoom.intro;
                currentOptions=questRoom.options;
                currentNum=questRoom.num;
                player.progress++;
                break;
            case 5:
                if (currentOption == 0){
                    player.progress=1;
                    update(0);
                }
                else if(currentOption==1){
                    finalRoom.win();
                    currentNum=finalRoom.num;
                    currentIntro=finalRoom.intro;
                    currentOptions=finalRoom.options;
                    isDead=true;
                    player.reset();
                }
                else if(currentOption==2){
                    finalRoom.loss();
                    currentNum=finalRoom.num;
                    currentIntro=finalRoom.intro;
                    currentOptions=finalRoom.options;
                    isDead=true;
                    player.reset();
                }
        }
    }
    public void changeCurrentData(Scene scene){
        this.currentIntro=scene.intro;
        this.currentOptions=scene.options;
        this.currentNum=scene.num;
    }
}
