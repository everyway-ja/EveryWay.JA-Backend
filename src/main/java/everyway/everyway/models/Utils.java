package everyway.everyway.models;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Component

public class Utils {
    
    @Value("${file.upload.path}")  private String uploadPath;
    @Value("${file.personal.email}")  private String personalEmail;

    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * Encrypts the provided password using the SHA-256 hashing algorithm.
     * This method takes a plain text password, applies the SHA-256 hash function,
     * and returns the hashed value as a hexadecimal string.
     *
     * @param password the plain text password to be encrypted
     * @return a hexadecimal string representing the hashed password
     * @throws RuntimeException if there is an error while applying the SHA-256 algorithm
     */
    public String encryptString ( String password ) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }

    /**
     * Saves a file to the file system.
     * 
     * This method takes a MultipartFile, extracts its byte data, generates a hash of the file, 
     * determines the file path using the hash, creates necessary directories if they don't exist, 
     * and writes the file to the specified path if it doesn't already exist.
     * 
     * @param file the MultipartFile to be saved
     * @throws IOException if an I/O error occurs during the file processing or saving
     */
    public void save_file ( MultipartFile file ) throws IOException {

        byte[] fileBytes = file.getBytes();
        String fileHash = generate_fileHash(fileBytes);
    
        Path path = get_filePath(fileHash);
        create_directoriesIfNotExist(path);
    
        if (!Files.exists(path)) {
            Files.write(path, fileBytes);
        }

    }

    /**
     * Creates the directories for the specified path if they do not already exist.
     * This method checks the parent directory of the provided path and creates it 
     * along with any necessary parent directories if they don't already exist.
     *
     * @param path the path for which the parent directories need to be created
     * @throws IOException if an I/O error occurs while creating the directories
     */
    public void create_directoriesIfNotExist ( Path path ) throws IOException {
        Path directory = path.getParent();
        if (directory != null && !Files.exists(directory)) {
            Files.createDirectories(directory);
        }
    }

    public byte[] read_file ( String filename ) throws IOException {
        
        Path path = get_filePath(filename);

        return Files.readAllBytes(path);
    
    }

    /**
     * Combines multiple files into a single byte array.
     * 
     * This method takes an array of filenames, reads the content of each file, and combines the 
     * file contents into a single byte array. The resulting array contains the concatenated 
     * contents of all the files, in the same order as the filenames array.
     * 
     * @param filenames an array of file names to be combined
     * @return a byte array containing the combined contents of all files
     * @throws IOException if an I/O error occurs while reading any of the files
     */
    public byte[] combine_files ( String[] filenames ) throws IOException {

        int totalLength = 0;
        byte[][] fileContents = new byte[filenames.length][];

        for (int i = 0; i < filenames.length; i++) {
            fileContents[i] = read_file(filenames[i]);
            totalLength += fileContents[i].length;
        }

        byte[] combined = new byte[totalLength];
        int currentPosition = 0;

        for (byte[] fileContent : fileContents) {
            System.arraycopy(fileContent, 0, combined, currentPosition, fileContent.length);
            currentPosition += fileContent.length;
        }

        return combined;

    }

    /**
     * Retrieves the file path for the specified file.
     * 
     * This method sanitizes the given filename to ensure it only contains the name of the file 
     * (without any path information) and then constructs a path to the file within the specified 
     * upload directory.
     * 
     * @param filename the name of the file for which to retrieve the path
     * @return a Path object representing the full file path, combining the upload directory 
     *         and the sanitized filename
     */
    public Path get_filePath ( String filename ) {
        String sanitizedFilename = FilenameUtils.getName(filename);
        return Paths.get(uploadPath, sanitizedFilename);
    }

    /**
     * Generates a SHA-256 hash of the provided file bytes.
     * This method calculates the hash of the file content using the SHA-256 algorithm and 
     * returns the hash value as a hexadecimal string.
     *
     * @param fileBytes the content of the file as a byte array
     * @return the SHA-256 hash of the file content as a hexadecimal string
     * @throws RuntimeException if an error occurs while generating the hash
     */
    public String generate_fileHash ( byte[] fileBytes ) {
    
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(fileBytes);
            return new BigInteger(1, hashBytes).toString(16); // Convert to hex
    
        } 
        
        catch ( Exception e ) {
            throw new RuntimeException();
        }
    
    }

    /**
     * Sends an email with the details of a new contact.
     * 
     * This method constructs an email message with the provided name, email, and message, and 
     * sends it to a predefined personal email address. The subject of the email includes the 
     * name of the contact, and the body contains the name, email, and the message itself.
     * 
     * @param nome the name of the contact
     * @param email the email address of the contact
     * @param messaggio the message from the contact
     */
    public void sendEmail(String nome, String email, String messaggio) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(personalEmail);
        mailMessage.setSubject("Nuovo contatto da "+nome);
        mailMessage.setText("Nome: " + nome + "\nEmail: " + email + "\nMessaggio: " + messaggio);

        javaMailSender.send(mailMessage);
    }
}
