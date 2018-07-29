package at.atvgstudios.gitlab;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * The type Utils.
 * @author Thomas Obernosterer
 * @since 18.7.28.2
 */
public class Utils {

    /**
     * Gets version.
     *
     * @return the version
     */
    public static String getVersion() {
        return "18.7.29.2";
    }

    /**
     * Gets file.
     *
     * @param classAny the class any
     * @param fileName the file name
     * @return the file
     */
    public static String getFile(Class classAny, String fileName) {
        //Get file from resources folder
        ClassLoader classLoader = classAny.getClassLoader();

        InputStream stream = classLoader.getResourceAsStream(fileName);

        if (stream == null)
            stream = classAny.getResourceAsStream(fileName);

        try {
            if (stream == null) {
                throw new Exception("Cannot find file " + fileName);
            }

            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            final StringBuilder out = new StringBuilder();
            Reader in = new InputStreamReader(stream, StandardCharsets.UTF_8);
            for (; ; ) {
                int rsz = in.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }
            return out.toString();
        } catch (Exception e) {
            e.printStackTrace();

            System.exit(1);
        }

        return null;
    }

}
