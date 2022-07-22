package exercise14;

public class Main {

    public static void main(String[] args) {
        Car redRenault = RedRenaultLoganCarBuild.newInstance()
                .fixEngine()
                .fixBody()
                .build();
        redRenault.startEngine();
        redRenault.showData();

        Car blackAudi = BlackAudiCarBuild.newInstance().fixEngine().fixBody().build();
        blackAudi.showData();
    }

}
