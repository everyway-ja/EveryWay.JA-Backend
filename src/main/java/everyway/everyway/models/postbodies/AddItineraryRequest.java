package everyway.everyway.models.postbodies;

import java.util.List;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.Location;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.ItineraryCategory;

public class AddItineraryRequest {

    private String name;
    private String description;
    private Account associatedAccount;
    private List<Image> associatedImages;
    private List<Location> associatedLocations;
    private List<AccountCategory> associatedAccountCategories;
    private List<ItineraryCategory> associatedItineraryCategories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAssociatedAccount() {
        return associatedAccount;
    }

    public void setAssociatedAccount(Account associatedAccount) {
        this.associatedAccount = associatedAccount;
    }

    public List<Image> getAssociatedImages() {
        return associatedImages;
    }

    public void setAssociatedImages(List<Image> associatedImages) {
        this.associatedImages = associatedImages;
    }

    public List<Location> getAssociatedLocations() {
        return associatedLocations;
    }

    public void setAssociatedLocations(List<Location> associatedLocations) {
        this.associatedLocations = associatedLocations;
    }

    public List<AccountCategory> getAssociatedAccountCategories() {
        return associatedAccountCategories;
    }

    public void setAssociatedAccountCategories(List<AccountCategory> associatedAccountCategories) {
        this.associatedAccountCategories = associatedAccountCategories;
    }

    public List<ItineraryCategory> getAssociatedItineraryCategories() {
        return associatedItineraryCategories;
    }

    public void setAssociatedItineraryCategories(List<ItineraryCategory> associatedItineraryCategories) {
        this.associatedItineraryCategories = associatedItineraryCategories;
    }
    
}