public class Player {
    private PlayerLevel playerLevel;

    public Player() {
        upgradeLevel(new BeginnerLevel());
    }

    public void upgradeLevel(PlayerLevel playerLevel) {
        this.playerLevel = playerLevel;
        playerLevel.showLevelMessage();
    }

    public void play(int count) {
        playerLevel.go(count);
    }
}