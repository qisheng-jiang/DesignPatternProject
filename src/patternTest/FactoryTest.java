package patternTest;

import theme.Theme;
import theme.ThemeFactory;

public class FactoryTest {
    public static void main(String[] args) {
        //test Factory Pattern
        System.out.println("\n------Factory Pattern------\n");
        System.out.println("Please select the theme of the farm(Manor,Rainforest,Snowfield):");
        System.out.println("Manor");
        ThemeFactory themeFactory=new ThemeFactory();
        Theme t=themeFactory.getTheme("Manor");
        t.loadTheme();
    }
}
