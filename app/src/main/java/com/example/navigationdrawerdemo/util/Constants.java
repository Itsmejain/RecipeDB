package com.example.navigationdrawerdemo.util;

public class Constants {
    public static String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    public static String CCB_WEBSITE_LINK = "https://ccb.iiitd.ac.in/";
    public static String TAG = "RDB::";
    public static String BEARER_TOKEN = "token will be updated here with the http call";
    public static boolean BEARER_TOKEN_GENERATED_FLAG = false;
    public static String BEARER_TOKEN_USERNAME = "manas";
    public static String BEARER_TOKEN_PASSWORD = "manas_cosylab";
    public static String BEARER_TOKEN_SCOPE = "openid";
    public static String BEARER_TOKEN_CLIENT_ID= "app-ims";
    public static String BEARER_TOKEN_GRANT_TYPE= "password";
    public static String RETROFIT_BASE_URL= "https://cosylab.iiitd.edu.in/";
    public static final long BEARER_TOKEN_REFRESH_TIME = 250000;
    public static boolean RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED = false;
    public static String RECIPE_OF_THE_DAY_IMAGE_URL = "dummyurl";
    public static String[] REGIONS = {"Australian",
            "Belgian",
            "Canadian",
            "Caribbean",
            "Central American",
            "Chinese and Mongolian",
            "Deutschland",
            "Eastern European",
            "French",
            "Greek",
            "Indian Subcontinent",
            "Irish",
            "Italian",
            "Japanese",
            "Korean",
            "Mexican",
            "Middle Eastern",
            "Northern Africa",
            "Rest Africa",
            "Scandinavian",
            "South American",
            "Southeast Asian",
            "Spanish and Portuguese",
            "Thai",
            "UK"};

    public static String[] COUNTRIES={"Egyptian",
            "Nigerian",
            "Moroccan",
            "Rest Middle Eastern",
            "Chinese",
            "Thai",
            "Indonesian",
            "Bangladeshi",
            "Vietnamese",
            "Israeli",
            "Lebanese",
            "Filipino",
            "Indian",
            "Korean",
            "Malaysian",
            "Turkish",
            "Japanese",
            "Pakistani",
            "Australian",
            "Mexican",
            "Rest Caribbean",
            "Puerto Rican",
            "Jamaican",
            "Cuban",
            "Argentine",
            "Brazilian",
            "Colombian",
            "Chilean",
            "Peruvian",
            "Russian",
            "Danish",
            "Scottish",
            "English",
            "UK",
            "Welsh",
            "Hungarian",
            "Swedish",
            "Belgian",
            "Norwegian",
            "Austrian",
            "Greek",
            "French",
            "Swiss",
            "Portuguese",
            "Italian",
            "Polish",
            "Dutch",
            "Irish",
            "German",
            "Rest Eastern European",
            "Spanish",
            "Finnish",
            "Czech",
            "US",
            "Canadian",
            "Somalian",
            "Namibian",
            "Angolan",
            "Libyan",
            "Sudanese",
            "Ethiopian",
            "Laotian",
            "Nepalese",
            "Cambodian",
            "Palestinian",
            "Saudi Arabian",
            "Mongolian",
            "Iraqi",
            "New Zealander",
            "Honduran",
            "Costa Rican",
            "Guatemalan",
            "Ecuadorean",
            "Venezuelan",
            "Icelandic"};


    public static String dummyRecipe = "{\"_id\":\"6008225a33d1f591f32716ba\",\"cook_time\":35,\"prep_time\":10,\"url\":\"http://allrecipes.com/recipe/233456/egyptian-green-beans-with-carrots/\",\"servings\":4,\"img_url\":\"https://images.media-allrecipes.com/userphotos/560x315/2619313.jpg\",\"total_time\":45,\"protein\":15.5638,\"caffeine\":0,\"recipe_index\":1,\"recipe_id\":2611,\"recipe_title\":\"EgyptianGreenBeanswithCarrots\",\"adjusted_Protein\":0,\"alanine\":0.082,\"alcoholEthyl\":0,\"arginine\":0.2266,\"ash\":4.5639,\"asparticAcid\":0.3773,\"betaSitosterol\":0,\"betaine\":0.278,\"calciumCa\":73.195,\"campesterol\":0,\"carbohydratebydifference\":39.3312,\"carotenealpha\":9.28,\"carotenebeta\":290.12,\"cholesterol\":14.4,\"cholinetotal\":67.0492,\"copperCu\":0.4543,\"cryptoxanthinbeta\":0,\"cystine\":0.0246,\"dihydrophylloquinone\":0,\"energyKJ\":1618.007,\"energykcal\":386.767,\"fattyacidstotalmonounsaturated\":4.39,\"fattyacidstotalpolyunsaturated\":1.3338,\"fattyacidstotalpolyunsaturated150\":0,\"fattyacidstotalpolyunsaturated161c\":0,\"fattyacidstotalpolyunsaturated161t\":0,\"fattyacidstotalpolyunsaturated170\":0,\"fattyacidstotalpolyunsaturated171\":0,\"fattyacidstotalpolyunsaturated181c\":0,\"fattyacidstotalpolyunsaturated181t\":0,\"fattyacidstotalpolyunsaturated182CLAs\":0,\"fattyacidstotalpolyunsaturated182i\":0,\"fattyacidstotalpolyunsaturated182n6cc\":0,\"fattyacidstotalpolyunsaturated182tnotfurtherdefined\":0,\"fattyacidstotalpolyunsaturated182tt\":0,\"fattyacidstotalpolyunsaturated183n6ccc\":0,\"fattyacidstotalpolyunsaturated202n6cc\":0,\"fattyacidstotalpolyunsaturated203undifferentiated\":0,\"fattyacidstotalpolyunsaturated221c\":0,\"fattyacidstotalpolyunsaturated221t\":0,\"fattyacidstotalpolyunsaturated240\":0,\"fattyacidstotalpolyunsaturated241c\":0,\"fattyacidstotalsaturated\":12.7285,\"fattyacidstotalsaturated100\":0.5033,\"fattyacidstotalsaturated120\":6.392,\"fattyacidstotalsaturated140\":2.2752,\"fattyacidstotalsaturated141\":0,\"fattyacidstotalsaturated160\":2.3968,\"fattyacidstotalsaturated161undifferentiated\":0.4279,\"fattyacidstotalsaturated180\":0.661,\"fattyacidstotalsaturated181undifferentiated\":3.9185,\"fattyacidstotalsaturated182undifferentiated\":1.2802,\"fattyacidstotalsaturated183undifferentiated\":0.0532,\"fattyacidstotalsaturated184\":0,\"fattyacidstotalsaturated200\":0,\"fattyacidstotalsaturated201\":0.0195,\"fattyacidstotalsaturated204undifferentiated\":0,\"fattyacidstotalsaturated205n3EPA\":0,\"fattyacidstotalsaturated220\":0,\"fattyacidstotalsaturated221undifferentiated\":0,\"fattyacidstotalsaturated225n3DPA\":0,\"fattyacidstotalsaturated226n3DHA\":0,\"fattyacidstotalsaturated40\":0,\"fattyacidstotalsaturated60\":0.0272,\"fattyacidstotalsaturated80\":0.4488,\"fattyacidstotaltrans\":0,\"fattyacidstotaltransmonoenoic\":0,\"fattyacidstotaltranspolyenoic\":0,\"fattyacidstotaltranspolyenoic130\":0,\"fattyacidstotaltranspolyenoic151\":0,\"fattyacidstotaltranspolyenoic18111t181tn7\":0,\"fattyacidstotaltranspolyenoic183n3cccALA\":0,\"fattyacidstotaltranspolyenoic183i\":0,\"fattyacidstotaltranspolyenoic203n3\":0,\"fattyacidstotaltranspolyenoic203n6\":0,\"fattyacidstotaltranspolyenoic204n6\":0,\"fattyacidstotaltranspolyenoic215\":0,\"fattyacidstotaltranspolyenoic224\":0,\"fibertotaldietary\":4.128,\"fluorideF\":1.65,\"folateDFE\":56.52,\"folatefood\":56.52,\"folatetotal\":56.52,\"folicacid\":0,\"fructose\":3.807,\"galactose\":0,\"glucosedextrose\":4.795,\"glutamicacid\":1.1105,\"glycine\":0.0799,\"histidine\":0.0505,\"hydroxyproline\":0,\"ironFe\":2.4485,\"isoleucine\":0.0625,\"lactose\":0,\"leucine\":0.0957,\"luteineaxanthin\":11.76,\"lycopene\":9204.48,\"lysine\":0.1178,\"magnesiumMg\":50.285,\"maltose\":0.0896,\"manganeseMn\":0.5304,\"menaquinone4\":0,\"methionine\":0.0162,\"niacin\":8.809,\"pantothenicacid\":0.2657,\"phenylalanine\":0.0901,\"phosphorusP\":209.73,\"phytosterols\":35.65,\"potassiumK\":1077.135,\"proline\":0.048,\"retinol\":4.8,\"riboflavin\":0.505,\"seleniumSe\":13.858,\"serine\":0.0832,\"sodiumNa\":712.39,\"starch\":0.0704,\"stigmasterol\":0,\"sucrose\":1.581,\"sugarstotal\":17.9016,\"theobromine\":0,\"thiamin\":0.2692,\"threonine\":0.0835,\"tocopherolbeta\":0,\"tocopheroldelta\":0,\"tocopherolgamma\":0.1664,\"tocotrienolalpha\":0.06,\"tocotrienolbeta\":0,\"tocotrienoldelta\":0,\"tocotrienolgamma\":0,\"totallipidfat\":19.7239,\"tryptophanTyrosine\":null,\"valine\":0.0772,\"vitaminAIU\":505.94,\"vitaminARAE\":29.12,\"vitaminB12\":0,\"vitaminB12added\":0,\"vitaminB6\":0.6172,\"vitaminCtotalascorbicacid\":21.045,\"vitaminD2D3\":0,\"vitaminD\":0,\"vitaminD2ergocalciferol\":0,\"vitaminD3cholecalciferol\":0,\"vitaminEalphatocopherol\":2.073,\"vitaminEadded\":0,\"vitaminKphylloquinone\":8.6692,\"water\":603.0612,\"zincZn\":1.2356,\"utensils\":\"pot\",\"processes\":\"heat||heat||cook||stir||stir||cook||stirring||pour||stir||boil||add||boil||simmer\",\"calories\":80,\"continent\":\"African\",\"sub_region\":\"Egyptian\",\"region\":\"MiddleEastern\",\"source\":\"AllRecipes\"}";
    public static int[] INGREDIENT_COUNTS = {1062,20,55,99,102,113,145,174,177,189,218,224,309,367,414,456,475,484,544,571,667,706,976};
    public static String[] INGREDIENT_NAMES = {"Vegetable","Flower","Essential Oil","Fungi","Maize","Plant",
                                                "Nuts and Seeds","Seafood","Plant Derivative","Beverage","Fish",
                                                "Legume","Herb","Beverage-Alcoholic","Bakery","Cereal","Additive",
                                                "Spice","Condiment","Dairy","Fruit","Dish","Meat"};

    public static int[] PROCESS_COUNTS = {414241,16150,18083,20231,21705,21856,22296,24218,26433,27615,29616,30394,32527,38885,39045,43394,50039,50175,53890,55697,83579,94149,102841,188517};
    public static String[] PROCESS_NAMES = {"Other","Season","Set","Pour","Drain","Combine","Cut","Preheat","Cool","Sprinkle",
                                            "Stirring","Bake","Broil","Simmer","Boil","Serve","Remove","Cover","Mix",
                                            "Place","Stir","Cook","Heat","Add"};
    public static int[] UTENSIL_COUNTS = {71859,680,1088,1131,1935,2063,2347,2691,3982,4391,4399,4477,4607,5257,5260,7547,9139,13944,15243,21870,23596,35801,55803,68616};
    public static String[] UTENSIL_NAMES = {"Bowl","Sieve","Platter","Microwave","Board","Whisk","Cooker","Spoon",
                                            "Spatula","Container","Mixer","Other","Tablespoon","Plate","Knife","Fork",
                                            "Processor","Sheet","Dish","Cup","Saucepan","Pot","Skillet","Oven","Pan"};

    public static String[] INGREDIENT_CATEGORIES = {"Additive",
    "Additive-Salt", "Additive-Sugar", "Additive-Vinegar", "Additive-Yeast", "Bakery", "Beverage",
    "Beverage-Alcoholic", "Beverage-Caffeinated", "Cereal", "Condiment", "Condiment-Sauce",
    "Dairy", "Dish", "Essential Oil", "Fish", "Flower", "Fruit", "Fungi", "Herb", "Legume", "Maize", "Meat",
            "Nuts and Seeds", "Plant", "Plant Derivative", "Seafood", "Spice", "Vegetable"};

    public static String[] CONTINENTS = {"African","Asian","Australasian","Latin American","European","North American"};
}
