package theme;

public class ThemeFactory {
    public Theme getTheme(String themeType){
        if(themeType == null){
            return null;
        }
        if(themeType.equalsIgnoreCase("MANOR")){
            return new ManorTheme();
        } else if(themeType.equalsIgnoreCase("RAINFOREST")){
            return new RainforestTheme();
        } else if(themeType.equalsIgnoreCase("SNOWFIELD")){
            return new SnowfieldTheme();
        }
        return null;
    }
}
