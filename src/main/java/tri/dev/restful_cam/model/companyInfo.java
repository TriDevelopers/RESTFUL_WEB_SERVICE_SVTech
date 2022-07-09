package tri.dev.restful_cam.model;
import java.util.List;

public class companyInfo {
    private List<Company> ds;

    public List<Company> getDs() {
        return this.ds;
    }

    public void setDs(List<Company> ds) {
        this.ds = ds;
    }
    
    public String getName(int index) {
        return ds.get(index).getName();
    }

    public String getCode(int index) {
        return ds.get(index).getCode();
    }
}

class Company { 
    public String Name;
    public String Code;

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

}