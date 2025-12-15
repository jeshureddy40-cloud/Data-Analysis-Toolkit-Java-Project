import java.io.*;
import java.time.LocalDateTime;

public class FileOutput {

    public static void write(String result) throws DataException {

        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter("analysis.txt", true))) {

            bw.write("====================================\n");
            bw.write("Result Time: " + LocalDateTime.now() + "\n");
            bw.write(result + "\n");

        } catch (IOException e) {
            throw new DataException("Error writing to output file");
        }

        // 🔥 ALSO PRINT TO CONSOLE (VERY IMPORTANT)
        System.out.println("Output written to analysis.txt");
        System.out.println(result);
    }
}
