package tri.dev.restful_cam.model;
public class infoGathered {
    private String Cam_Code;
    private String Name;
    private String Branch_Code;
    private String Branch_Name;
    private String Company_Code;
    private String Company_Name;
    final private boolean IsEnable = true; // set it true for now, need work on this later


    public infoGathered() {
    }

    public infoGathered(String Cam_Code, String Name, String Branch_Code, String Branch_Name, String Company_Code, String Company_Name) {
        this.Cam_Code = Cam_Code;
        this.Name = Name;
        this.Branch_Code = Branch_Code;
        this.Branch_Name = Branch_Name;
        this.Company_Code = Company_Code;
        this.Company_Name = Company_Name;
    }

    public String getCam_Code() {
        return this.Cam_Code;
    }

    public void setCam_Code(String Cam_Code) {
        this.Cam_Code = Cam_Code;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBranch_Code() {
        return this.Branch_Code;
    }

    public void setBranch_Code(String Branch_Code) {
        this.Branch_Code = Branch_Code;
    }

    public String getBranch_Name() {
        return this.Branch_Name;
    }

    public void setBranch_Name(String Branch_Name) {
        this.Branch_Name = Branch_Name;
    }

    public String getCompany_Code() {
        return this.Company_Code;
    }

    public void setCompany_Code(String Company_Code) {
        this.Company_Code = Company_Code;
    }

    public String getCompany_Name() {
        return this.Company_Name;
    }

    public void setCompany_Name(String Company_Name) {
        this.Company_Name = Company_Name;
    }

    public boolean isIsEnable() {
        return this.IsEnable;
    }

    public boolean getIsEnable() {
        return this.IsEnable;
    }
    

    @Override
    public String toString() {
        return "{" +
            " Cam_Code='" + getCam_Code() + "'" +
            ", Name='" + getName() + "'" +
            ", Branch_Code='" + getBranch_Code() + "'" +
            ", Branch_Name='" + getBranch_Name() + "'" +
            ", Company_Code='" + getCompany_Code() + "'" +
            ", Company_Name='" + getCompany_Name() + "'" +
            ", IsEnable='" + isIsEnable() + "'" +
            "}";
    }
}
