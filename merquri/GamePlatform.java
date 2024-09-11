package merquri;

// Question One
public class GamePlatform {
    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        double speed = initialSpeed;

        for (int inclination : inclinations) {
            if (inclination != 0) {
                speed += (-inclination / 100.0) * speed;
            }
        }
        return speed;
    }

    // My understanding of the question is that when it goes down 30 degree, then it would accelerate 30%
    // if it goes up 45 degree, then it would deccelerate 45%
    // so this is my basic understanding of the question
    public static void main(String[] args) {
        System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); // Expected: 45.0
    }
}
