package tri.dev.restful_cam.model;

import java.util.List;

public class branchInfo {
    private List<Branch> ds;

    public List<Branch> getDs() {
        return this.ds;
    }

    public void setDs(List<Branch> ds) {
        this.ds = ds;
    }

    public String getName(int index) {
        return ds.get(index).getName();
    }

    public String getCode(int index) {
        return ds.get(index).getCode();
    }

    public String getCompany_Code(int index) {
        return ds.get(index).getCompany_Code();
    }

}

class Branch {
    public String Name;
    public String Code;
    public String Company_Code;

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

    public String getCompany_Code() {
        return this.Company_Code;
    }

    public void setCompany_Code(String Company_Code) {
        this.Company_Code = Company_Code;
    }
}
