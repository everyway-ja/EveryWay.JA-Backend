package everyway.everyway.models.postbodies;

import java.time.LocalDate;
import java.util.List;
import everyway.everyway.models.tables.*;

public class RegisterRequest {
    
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;
    private Language associatedLanguage;
    private Image associatedImage;
    private List<AccountCategory> associatedAccountCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Language getAssociatedLanguage() {
        return associatedLanguage;
    }

    public void setAssociatedLanguage(Language associatedLanguage) {
        this.associatedLanguage = associatedLanguage;
    }

    public Image getAssociatedImage() {
        return associatedImage;
    }

    public void setAssociatedImage(Image associatedImage) {
        this.associatedImage = associatedImage;
    }

    public List<AccountCategory> getAssociatedAccountCategories() {
        return associatedAccountCategories;
    }

    public void setAssociatedAccountCategories(List<AccountCategory> associatedAccountCategories) {
        this.associatedAccountCategories = associatedAccountCategories;
    }

}