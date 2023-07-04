import java.util.ArrayList;
import java.util.List;

public class TownManager {
    private List<Family> families;

    public TownManager() {
        this.families = new ArrayList<>();
    }

    public List<Family> getFamilies() {
        return families;
    }

    public void setFamilies(List<Family> families) {
        this.families = families;
    }

    public void addFamily(Family family) {
        families.add(family);
    }

    public void showInfor() {
        System.out.println("Town information:");
        families.forEach(familiy -> {
            System.out.println(familiy.toString()); 
        });
    }
}
