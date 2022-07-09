package tri.dev.restful_cam.model;
import java.util.List;

public class cameraInfo {
    private List<Camera> ds;

    public List<Camera> getDs() {
        return this.ds;
    }

    public void setDs(List<Camera> ds) {
        this.ds = ds;
    }

    public String getName(int index) {
        return ds.get(index).getName();
    }

    public String getCode(int index) {
        return ds.get(index).getCode();
    }

    public String getBranch_Id(int index) {
        return ds.get(index).getBranch_Id();
    }
}

class Camera {
    public String Name;
    public String Code;
    public String Branch_Id;

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCode() {
        return this.Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getBranch_Id() {
        return this.Branch_Id;
    }

    public void setBranch_Id(String Branch_Id) {
        this.Branch_Id = Branch_Id;
    }
}