package everyway.everyway.models.postbodies;

import org.springframework.web.multipart.MultipartFile;

public class MultipleFileUploadRequest {
    
    private MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

}
