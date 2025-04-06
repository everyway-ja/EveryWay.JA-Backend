package everyway.everyway.models.postbodies;

import java.util.List;
import everyway.everyway.models.tables.Account;
import everyway.everyway.models.tables.Position;
import everyway.everyway.models.tables.Image;
import everyway.everyway.models.tables.AccountCategory;
import everyway.everyway.models.tables.LocationCategory;

public class AddLocationRequest {

    private String name;
    private String description;
    private Account associatedAccount;
    private Position associatedPosition;
    private List<Image> associatedImages;
    private List<AccountCategory> associatedAccountCategories;
    private List<LocationCategory> associatedLocationCategories;

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

    public Position getAssociatedPosition() {
        return associatedPosition;
    }

    public void setAssociatedPosition(Position associatedPosition) {
        this.associatedPosition = associatedPosition;
    }

    public List<Image> getAssociatedImages() {
        return associatedImages;
    }

    public void setAssociatedImages(List<Image> associatedImages) {
        this.associatedImages = associatedImages;
    }

    public List<AccountCategory> getAssociatedAccountCategories() {
        return associatedAccountCategories;
    }

    public void setAssociatedAccountCategories(List<AccountCategory> associatedAccountCategories) {
        this.associatedAccountCategories = associatedAccountCategories;
    }

    public List<LocationCategory> getAssociatedLocationCategories() {
        return associatedLocationCategories;
    }

    public void setAssociatedLocationCategories(List<LocationCategory> associatedLocationCategories) {
        this.associatedLocationCategories = associatedLocationCategories;
    }

}