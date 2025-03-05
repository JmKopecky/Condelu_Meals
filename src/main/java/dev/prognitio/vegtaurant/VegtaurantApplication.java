package dev.prognitio.vegtaurant;

import dev.prognitio.vegtaurant.data_storage.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class VegtaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(VegtaurantApplication.class, args);
	}


	public static void doDatabaseTestCase(MenuCategoryRepository menuCategoryRepository, MenuItemRepository menuItemRepository, FeaturedItemRepository featuredItemRepository, ProductRatingRepository productRatingRepository, AccountRepository accountRepository, RestaurantLocationRepository restaurantLocationRepository, PlacedOrderRepository placedOrderRepository, RestaurantRatingRepository restaurantRating) { //TODO delete before completion

		if (menuCategoryRepository.count() != 0) {
			return;
		}

		MenuCategory breakfast = new MenuCategory();
		breakfast.setTitle("Breakfast");
		menuCategoryRepository.save(breakfast);

		MenuCategory dinner = new MenuCategory();
		dinner.setTitle("Dinner");
		menuCategoryRepository.save(dinner);

		MenuCategory sides = new MenuCategory();
		sides.setTitle("Sides");
		menuCategoryRepository.save(sides);

		MenuCategory drinks = new MenuCategory();
		drinks.setTitle("Drinks");
		menuCategoryRepository.save(drinks);

		MenuCategory desserts = new MenuCategory();
		desserts.setTitle("Desserts");
		menuCategoryRepository.save(desserts);


		HashMap<String, String> nutritionalFacts;


		//note drinks
		MenuItem waterOption = new MenuItem();
		waterOption.setLabel("Water");
		waterOption.setTag("Misc Drinks");
		waterOption.setDescription("Filtered to be entirely clear and clean.");
		waterOption.setIconUrl("images/products/drinks/water.jpg");
		waterOption.setPrice(0.25);
		waterOption.setCategory(drinks);
		waterOption.setAveragerating(5);
		waterOption.setTotalratings(1);
		waterOption.setNutritionFacts(new HashMap<>());
		waterOption.getNutritionFacts().put("Calories", "0");
		waterOption.getNutritionFacts().put("Carbs", "0g");
		waterOption.getNutritionFacts().put("Sugar", "0g");
		waterOption.getNutritionFacts().put("Protein", "0g");
		menuItemRepository.save(waterOption);


		MenuItem tea1 = new MenuItem();
		tea1.setLabel("Black Tea");
		tea1.setTag("Teas");
		tea1.setDescription("Your simple warm tea with a strong flavor, perfectly refreshing whilst not containing excessive sugar!");
		tea1.setIconUrl("images/products/drinks/blacktea.jpg");
		tea1.setPrice(2.0);
		tea1.setCategory(drinks);
		tea1.setAveragerating(5);
		tea1.setTotalratings(1);
		tea1.setNutritionFacts(new HashMap<>());
		tea1.getNutritionFacts().put("Calories", "2");
		tea1.getNutritionFacts().put("Carbs", "1g");
		tea1.getNutritionFacts().put("Sugar", "0g");
		tea1.getNutritionFacts().put("Protein", "0g");
		menuItemRepository.save(tea1);

		MenuItem tea2 = new MenuItem();
		tea2.setLabel("Iced Tea");
		tea2.setTag("Teas");
		tea2.setDescription("Made with the same leaves as our black tea, this nonetheless is kept chilled: perfect on hot days!\n");
		tea2.setIconUrl("images/products/drinks/icedtea.jpg");
		tea2.setPrice(2.0);
		tea2.setCategory(drinks);
		tea2.setAveragerating(5);
		tea2.setTotalratings(1);
		tea2.setNutritionFacts(new HashMap<>());
		tea2.getNutritionFacts().put("Calories", "73");
		tea2.getNutritionFacts().put("Sugar", "5g");
		tea2.getNutritionFacts().put("Protein", "0g");
		menuItemRepository.save(tea2);

		MenuItem tea3 = new MenuItem();
		tea3.setLabel("Green Tea");
		tea3.setTag("Teas");
		tea3.setDescription("Combine immense health benefits with a nice, earthy flavor.");
		tea3.setIconUrl("images/products/drinks/greentea.jpg");
		tea3.setPrice(2.5);
		tea3.setCategory(drinks);
		tea3.setAveragerating(5);
		tea3.setTotalratings(1);
		tea3.setNutritionFacts(new HashMap<>());
		tea3.getNutritionFacts().put("Calories", "3");
		tea3.getNutritionFacts().put("Sugar", "0g");
		tea3.getNutritionFacts().put("Protein", "0g");
		menuItemRepository.save(tea3);

		MenuItem applejuice = new MenuItem();
		applejuice.setLabel("Apple Juice");
		applejuice.setTag("Juices");
		applejuice.setDescription("Freshly and locally picked apples, juiced ready to order.");
		applejuice.setIconUrl("images/products/drinks/applejuice.jpg");
		applejuice.setPrice(1);
		applejuice.setCategory(drinks);
		applejuice.setAveragerating(5);
		applejuice.setTotalratings(1);
		applejuice.setNutritionFacts(new HashMap<>());
		applejuice.getNutritionFacts().put("Calories", "98");
		applejuice.getNutritionFacts().put("Protein", "0g");
		applejuice.getNutritionFacts().put("Sugar", "0g");
		menuItemRepository.save(applejuice);

		MenuItem orangejuice = new MenuItem();
		orangejuice.setLabel("Orange Juice");
		orangejuice.setTag("Juices");
		orangejuice.setDescription("Freshly grown oranges sourced locally, juiced including pulp for maximum nutrition.");
		orangejuice.setIconUrl("images/products/drinks/orangejuice.jpg");
		orangejuice.setPrice(1);
		orangejuice.setCategory(drinks);
		orangejuice.setAveragerating(5);
		orangejuice.setTotalratings(1);
		orangejuice.setNutritionFacts(new HashMap<>());
		orangejuice.getNutritionFacts().put("Calories", "113");
		orangejuice.getNutritionFacts().put("Protein", "0g");
		orangejuice.getNutritionFacts().put("Sugar", "0g");
		menuItemRepository.save(orangejuice);

		MenuItem grapejuice = new MenuItem();
		grapejuice.setLabel("Grape Juice");
		grapejuice.setTag("Juices");
		grapejuice.setDescription("Grapes picked fresh by local partners, steam-juiced for maximum flavor.");
		grapejuice.setIconUrl("images/products/drinks/grapejuice.jpg");
		grapejuice.setPrice(1.5);
		grapejuice.setCategory(drinks);
		grapejuice.setAveragerating(5);
		grapejuice.setTotalratings(1);
		grapejuice.setNutritionFacts(new HashMap<>());
		grapejuice.getNutritionFacts().put("Calories", "153");
		grapejuice.getNutritionFacts().put("Protein", "1g");
		grapejuice.getNutritionFacts().put("Sugar", "0g");
		menuItemRepository.save(grapejuice);

		//note: breakfast
		MenuItem eggBreakfastSandwich = new MenuItem();
		eggBreakfastSandwich.setLabel("Egg Breakfast Sandwich");
		eggBreakfastSandwich.setTag("Breakfast Sandwiches");
		eggBreakfastSandwich.setDescription("A delicious fried egg on a brioche bun.");
		eggBreakfastSandwich.setIconUrl("images/products/breakfast/eggbreakfastsandwich.jpg");
		eggBreakfastSandwich.setPrice(4);
		eggBreakfastSandwich.setCategory(breakfast);
		eggBreakfastSandwich.setAveragerating(5);
		eggBreakfastSandwich.setTotalratings(1);
		eggBreakfastSandwich.setNutritionFacts(new HashMap<>());
		eggBreakfastSandwich.getNutritionFacts().put("Calories", "242");
		eggBreakfastSandwich.getNutritionFacts().put("Carbs", "21g");
		eggBreakfastSandwich.getNutritionFacts().put("Fat", "7g");
		eggBreakfastSandwich.getNutritionFacts().put("Protein", "12g");
		menuItemRepository.save(eggBreakfastSandwich);

		MenuItem frenchToast = new MenuItem();
		frenchToast.setLabel("French Toast");
		frenchToast.setTag("Breads & Grain");
		frenchToast.setDescription("Two slices of delectable french toast, covered in delicious mixed berries.");
		frenchToast.setIconUrl("images/products/breakfast/frenchtoast.jpg");
		frenchToast.setPrice(2.5);
		frenchToast.setCategory(breakfast);
		frenchToast.setAveragerating(5);
		frenchToast.setTotalratings(1);
		frenchToast.setNutritionFacts(new HashMap<>());
		frenchToast.getNutritionFacts().put("Calories", "121");
		frenchToast.getNutritionFacts().put("Carbs", "19g");
		frenchToast.getNutritionFacts().put("Fat", "6g");
		frenchToast.getNutritionFacts().put("Protein", "11g");
		menuItemRepository.save(frenchToast);

		MenuItem waffles = new MenuItem();
		waffles.setLabel("Waffles");
		waffles.setTag("Breads & Grain");
		waffles.setDescription("Crispy waffles, toasted to perfection.");
		waffles.setIconUrl("images/products/breakfast/waffles.jpg");
		waffles.setPrice(1.5);
		waffles.setCategory(breakfast);
		waffles.setAveragerating(5);
		waffles.setTotalratings(1);
		waffles.setNutritionFacts(new HashMap<>());
		waffles.getNutritionFacts().put("Calories", "92");
		waffles.getNutritionFacts().put("Carbs", "29g");
		waffles.getNutritionFacts().put("Fat", "5g");
		waffles.getNutritionFacts().put("Protein", "4g");
		menuItemRepository.save(waffles);

		MenuItem cereal = new MenuItem();
		cereal.setLabel("Cereal");
		cereal.setTag("Breads & Grain");
		cereal.setDescription("An old classic! All-grain cereal mixed with assorted berries.");
		cereal.setIconUrl("images/products/breakfast/cereal.jpg");
		cereal.setPrice(1);
		cereal.setCategory(breakfast);
		cereal.setAveragerating(5);
		cereal.setTotalratings(1);
		cereal.setNutritionFacts(new HashMap<>());
		cereal.getNutritionFacts().put("Calories", "67");
		cereal.getNutritionFacts().put("Carbs", "27g");
		cereal.getNutritionFacts().put("Fat", "0g");
		cereal.getNutritionFacts().put("Protein", "5g");
		menuItemRepository.save(cereal);

		MenuItem strawberryYogurt = new MenuItem();
		strawberryYogurt.setLabel("Strawberry Yogurt");
		strawberryYogurt.setTag("Milk-Based");
		strawberryYogurt.setDescription("Perfectly creamy yogurt bowl mixed with crushed strawberries and a biscuit.");
		strawberryYogurt.setIconUrl("images/products/breakfast/strawberryyogurt.jpg");
		strawberryYogurt.setPrice(1.5);
		strawberryYogurt.setCategory(breakfast);
		strawberryYogurt.setAveragerating(5);
		strawberryYogurt.setTotalratings(1);
		strawberryYogurt.setNutritionFacts(new HashMap<>());
		strawberryYogurt.getNutritionFacts().put("Calories", "78");
		strawberryYogurt.getNutritionFacts().put("Carbs", "9g");
		strawberryYogurt.getNutritionFacts().put("Fat", "1g");
		strawberryYogurt.getNutritionFacts().put("Protein", "12g");
		menuItemRepository.save(strawberryYogurt);

		MenuItem sweetBerrySmoothie = new MenuItem();
		sweetBerrySmoothie.setLabel("Sweet Berry Smoothie");
		sweetBerrySmoothie.setTag("Milk-Based");
		sweetBerrySmoothie.setDescription("Down a nice smoothie with delicious blackberries.");
		sweetBerrySmoothie.setIconUrl("images/products/breakfast/smoothie.jpg");
		sweetBerrySmoothie.setPrice(1.5);
		sweetBerrySmoothie.setCategory(breakfast);
		sweetBerrySmoothie.setAveragerating(5);
		sweetBerrySmoothie.setTotalratings(1);
		sweetBerrySmoothie.setNutritionFacts(new HashMap<>());
		sweetBerrySmoothie.getNutritionFacts().put("Calories", "117");
		sweetBerrySmoothie.getNutritionFacts().put("Carbs", "13g");
		sweetBerrySmoothie.getNutritionFacts().put("Fat", "1g");
		sweetBerrySmoothie.getNutritionFacts().put("Protein", "11g");
		menuItemRepository.save(sweetBerrySmoothie);

		MenuItem cheesyCroissantSandwich = new MenuItem();
		cheesyCroissantSandwich.setLabel("Cheesy Croissant Sandwich");
		cheesyCroissantSandwich.setTag("Breakfast Sandwiches");
		cheesyCroissantSandwich.setDescription("Savor a perfectly baked croissant with a delicious cheese filling.");
		cheesyCroissantSandwich.setIconUrl("images/products/breakfast/croissantsandwich.jpg");
		cheesyCroissantSandwich.setPrice(1.5);
		cheesyCroissantSandwich.setCategory(breakfast);
		cheesyCroissantSandwich.setAveragerating(5);
		cheesyCroissantSandwich.setTotalratings(1);
		cheesyCroissantSandwich.setNutritionFacts(new HashMap<>());
		cheesyCroissantSandwich.getNutritionFacts().put("Calories", "435");
		cheesyCroissantSandwich.getNutritionFacts().put("Carbs", "23g");
		cheesyCroissantSandwich.getNutritionFacts().put("Fat", "12g");
		cheesyCroissantSandwich.getNutritionFacts().put("Protein", "10g");
		menuItemRepository.save(cheesyCroissantSandwich);

		MenuItem bagelSandwich = new MenuItem();
		bagelSandwich.setLabel("Bagel Sandwich");
		bagelSandwich.setTag("Breakfast Sandwiches");
		bagelSandwich.setDescription("Enjoy a seed-filled bagel containing delectably creamy cheese and egg.");
		bagelSandwich.setIconUrl("images/products/breakfast/bagelsandwich.jpg");
		bagelSandwich.setPrice(1.5);
		bagelSandwich.setCategory(breakfast);
		bagelSandwich.setAveragerating(5);
		bagelSandwich.setTotalratings(1);
		bagelSandwich.setNutritionFacts(new HashMap<>());
		bagelSandwich.getNutritionFacts().put("Calories", "421");
		bagelSandwich.getNutritionFacts().put("Carbs", "47g");
		bagelSandwich.getNutritionFacts().put("Fat", "9g");
		bagelSandwich.getNutritionFacts().put("Protein", "16g");
		menuItemRepository.save(bagelSandwich);


		//note: dinner
		MenuItem spicyPasta = new MenuItem();
		spicyPasta.setLabel("Spicy Pasta");
		spicyPasta.setTag("Pasta");
		spicyPasta.setDescription("Delicious pasta, with chili peppers for a dash of spice.");
		spicyPasta.setIconUrl("images/products/dinner/spicypasta.jpg");
		spicyPasta.setPrice(4);
		spicyPasta.setCategory(dinner);
		spicyPasta.setAveragerating(5);
		spicyPasta.setTotalratings(1);
		spicyPasta.setNutritionFacts(new HashMap<>());
		spicyPasta.getNutritionFacts().put("Calories", "307");
		spicyPasta.getNutritionFacts().put("Carbs", "41g");
		spicyPasta.getNutritionFacts().put("Fat", "7g");
		spicyPasta.getNutritionFacts().put("Protein", "10g");
		menuItemRepository.save(spicyPasta);

		MenuItem spaghetti = new MenuItem();
		spaghetti.setLabel("Spaghetti");
		spaghetti.setTag("Pasta");
		spaghetti.setDescription("Spaghetti basking in red sauce, filled with tomatoes.");
		spaghetti.setIconUrl("images/products/dinner/sphagetti.jpg");
		spaghetti.setPrice(3.5);
		spaghetti.setCategory(dinner);
		spaghetti.setAveragerating(5);
		spaghetti.setTotalratings(1);
		spaghetti.setNutritionFacts(new HashMap<>());
		spaghetti.getNutritionFacts().put("Calories", "197");
		spaghetti.getNutritionFacts().put("Carbs", "37g");
		spaghetti.getNutritionFacts().put("Fat", "2g");
		spaghetti.getNutritionFacts().put("Protein", "8g");
		menuItemRepository.save(spaghetti);

		MenuItem riceVeggieBowl = new MenuItem();
		riceVeggieBowl.setLabel("Rice Veggie Bowl");
		riceVeggieBowl.setTag("Dinner Bowls");
		riceVeggieBowl.setDescription("Bowl of rice with mixed in cucumbers, tomatoes, and assorted greens.");
		riceVeggieBowl.setIconUrl("images/products/dinner/riceveggiebowl.jpg");
		riceVeggieBowl.setPrice(2);
		riceVeggieBowl.setCategory(dinner);
		riceVeggieBowl.setAveragerating(5);
		riceVeggieBowl.setTotalratings(1);
		riceVeggieBowl.setNutritionFacts(new HashMap<>());
		riceVeggieBowl.getNutritionFacts().put("Calories", "206");
		riceVeggieBowl.getNutritionFacts().put("Carbs", "45g");
		riceVeggieBowl.getNutritionFacts().put("Fat", "2g");
		riceVeggieBowl.getNutritionFacts().put("Protein", "7g");
		menuItemRepository.save(riceVeggieBowl);

		MenuItem riceBeanBowl = new MenuItem();
		riceBeanBowl.setLabel("Rice Bean Bowl");
		riceBeanBowl.setTag("Dinner Bowls");
		riceBeanBowl.setDescription("A bowl of rice mixed with protein-rich beans.");
		riceBeanBowl.setIconUrl("images/products/dinner/ricebeanbowl.jpg");
		riceBeanBowl.setPrice(2);
		riceBeanBowl.setCategory(dinner);
		riceBeanBowl.setAveragerating(5);
		riceBeanBowl.setTotalratings(1);
		riceBeanBowl.setNutritionFacts(new HashMap<>());
		riceBeanBowl.getNutritionFacts().put("Calories", "143");
		riceBeanBowl.getNutritionFacts().put("Carbs", "35g");
		riceBeanBowl.getNutritionFacts().put("Fat", "3g");
		riceBeanBowl.getNutritionFacts().put("Protein", "16g");
		menuItemRepository.save(riceBeanBowl);

		MenuItem greenBeanBowl = new MenuItem();
		greenBeanBowl.setLabel("Green Bean Bowl");
		greenBeanBowl.setTag("Dinner Bowls");
		greenBeanBowl.setDescription("Bowl of fresh seasoned green beans.");
		greenBeanBowl.setIconUrl("images/products/dinner/greenbeanbowl.jpg");
		greenBeanBowl.setPrice(2);
		greenBeanBowl.setCategory(dinner);
		greenBeanBowl.setAveragerating(5);
		greenBeanBowl.setTotalratings(1);
		greenBeanBowl.setNutritionFacts(new HashMap<>());
		greenBeanBowl.getNutritionFacts().put("Calories", "31");
		greenBeanBowl.getNutritionFacts().put("Carbs", "7g");
		greenBeanBowl.getNutritionFacts().put("Fat", "0g");
		greenBeanBowl.getNutritionFacts().put("Protein", "2g");
		menuItemRepository.save(greenBeanBowl);

		MenuItem saladPlate = new MenuItem();
		saladPlate.setLabel("Salad Plate");
		saladPlate.setTag("Salads");
		saladPlate.setDescription("Fresh plate of salad consisting of assorted herbs, tomatoes, radishes, and cucumbers.");
		saladPlate.setIconUrl("images/products/dinner/saladplate.jpg");
		saladPlate.setPrice(2);
		saladPlate.setCategory(dinner);
		saladPlate.setAveragerating(5);
		saladPlate.setTotalratings(1);
		saladPlate.setNutritionFacts(new HashMap<>());
		saladPlate.getNutritionFacts().put("Calories", "135");
		saladPlate.getNutritionFacts().put("Carbs", "3g");
		saladPlate.getNutritionFacts().put("Fat", "0g");
		saladPlate.getNutritionFacts().put("Protein", "2g");
		menuItemRepository.save(saladPlate);

		MenuItem gourmetSoup = new MenuItem();
		gourmetSoup.setLabel("Gourmet Soup");
		gourmetSoup.setTag("Dinner Bowls");
		gourmetSoup.setDescription("Perfectly creamy soup with chives, parsley, squash, and assorted herbs.");
		gourmetSoup.setIconUrl("images/products/dinner/gourmetsoup.jpg");
		gourmetSoup.setPrice(3);
		gourmetSoup.setCategory(dinner);
		gourmetSoup.setAveragerating(5);
		gourmetSoup.setTotalratings(1);
		gourmetSoup.setNutritionFacts(new HashMap<>());
		gourmetSoup.getNutritionFacts().put("Calories", "74");
		gourmetSoup.getNutritionFacts().put("Carbs", "16g");
		gourmetSoup.getNutritionFacts().put("Fat", "2g");
		gourmetSoup.getNutritionFacts().put("Protein", "7g");
		menuItemRepository.save(gourmetSoup);

		MenuItem herbalPearPizza = new MenuItem();
		herbalPearPizza.setLabel("Herbal Pear Pizza");
		herbalPearPizza.setTag("Pizza");
		herbalPearPizza.setDescription("A delectable cheese pizza with slices of fresh pears, covered in assorted herbs.");
		herbalPearPizza.setIconUrl("images/products/dinner/herbalpearpizza.jpg");
		herbalPearPizza.setPrice(6);
		herbalPearPizza.setCategory(dinner);
		herbalPearPizza.setAveragerating(5);
		herbalPearPizza.setTotalratings(1);
		herbalPearPizza.setNutritionFacts(new HashMap<>());
		herbalPearPizza.getNutritionFacts().put("Calories", "342");
		herbalPearPizza.getNutritionFacts().put("Carbs", "47g");
		herbalPearPizza.getNutritionFacts().put("Fat", "7g");
		herbalPearPizza.getNutritionFacts().put("Protein", "9g");
		menuItemRepository.save(herbalPearPizza);

		MenuItem crispyMediterraneanPizza = new MenuItem();
		crispyMediterraneanPizza.setLabel("Crispy Mediterranean Pizza");
		crispyMediterraneanPizza.setTag("Pizza");
		crispyMediterraneanPizza.setDescription("Cheesy and crispy mediterranean pizza with zucchini, eggplants, and red pepper.");
		crispyMediterraneanPizza.setIconUrl("images/products/dinner/crispymeditarraneanpizza.jpg");
		crispyMediterraneanPizza.setPrice(8);
		crispyMediterraneanPizza.setCategory(dinner);
		crispyMediterraneanPizza.setAveragerating(5);
		crispyMediterraneanPizza.setTotalratings(1);
		crispyMediterraneanPizza.setNutritionFacts(new HashMap<>());
		crispyMediterraneanPizza.getNutritionFacts().put("Calories", "326");
		crispyMediterraneanPizza.getNutritionFacts().put("Carbs", "42g");
		crispyMediterraneanPizza.getNutritionFacts().put("Fat", "9g");
		crispyMediterraneanPizza.getNutritionFacts().put("Protein", "15g");
		menuItemRepository.save(crispyMediterraneanPizza);


		FeaturedItem pizzaDeal = new FeaturedItem();
		pizzaDeal.setFeaturedPrecedence(101);
		pizzaDeal.setIsPercentageBased(true);
		pizzaDeal.setDiscount(25);
		pizzaDeal.setMessage("Feed you and your friends with a discount on mediterranean pizza!");
		featuredItemRepository.save(pizzaDeal);

		crispyMediterraneanPizza.setDeal(pizzaDeal);
		menuItemRepository.save(crispyMediterraneanPizza);


		MenuItem cheeseSandwich = new MenuItem();
		cheeseSandwich.setLabel("Cheese Sandwich");
		cheeseSandwich.setTag("Sandwiches");
		cheeseSandwich.setDescription("Freshly toasted artisanal bread with creamy cheese filling.");
		cheeseSandwich.setIconUrl("images/products/dinner/cheesesandwich.jpg");
		cheeseSandwich.setPrice(1.5);
		cheeseSandwich.setCategory(dinner);
		cheeseSandwich.setAveragerating(5);
		cheeseSandwich.setTotalratings(1);
		cheeseSandwich.setNutritionFacts(new HashMap<>());
		cheeseSandwich.getNutritionFacts().put("Calories", "289");
		cheeseSandwich.getNutritionFacts().put("Carbs", "14g");
		cheeseSandwich.getNutritionFacts().put("Fat", "5g");
		cheeseSandwich.getNutritionFacts().put("Protein", "4g");
		menuItemRepository.save(cheeseSandwich);

		MenuItem grilledSandwichPlatter = new MenuItem();
		grilledSandwichPlatter.setLabel("Grilled Sandwich Platter");
		grilledSandwichPlatter.setTag("Sandwiches");
		grilledSandwichPlatter.setDescription("A spread of finger sandwiches, grilled to perfection.");
		grilledSandwichPlatter.setIconUrl("images/products/dinner/grilledsandwichplatter.jpg");
		grilledSandwichPlatter.setPrice(4);
		grilledSandwichPlatter.setCategory(dinner);
		grilledSandwichPlatter.setAveragerating(5);
		grilledSandwichPlatter.setTotalratings(1);
		grilledSandwichPlatter.setNutritionFacts(new HashMap<>());
		grilledSandwichPlatter.getNutritionFacts().put("Calories", "301");
		grilledSandwichPlatter.getNutritionFacts().put("Carbs", "22g");
		grilledSandwichPlatter.getNutritionFacts().put("Fat", "10g");
		grilledSandwichPlatter.getNutritionFacts().put("Protein", "11g");
		menuItemRepository.save(grilledSandwichPlatter);


		//note desserts
		MenuItem strawberryPie = new MenuItem();
		strawberryPie.setLabel("Strawberry Pie");
		strawberryPie.setTag("Pies");
		strawberryPie.setDescription("Have a slice of delicious, sweet strawberry pie, made with a crispy whole grain crust that ensures a guilt free eating experience.");
		strawberryPie.setIconUrl("images/products/desserts/strawberrypie.jpg");
		strawberryPie.setPrice(3);
		strawberryPie.setCategory(desserts);
		strawberryPie.setAveragerating(5);
		strawberryPie.setTotalratings(1);
		strawberryPie.setNutritionFacts(new HashMap<>());
		strawberryPie.getNutritionFacts().put("Calories", "136");
		strawberryPie.getNutritionFacts().put("Carbs", "41g");
		strawberryPie.getNutritionFacts().put("Fat", "8g");
		strawberryPie.getNutritionFacts().put("Protein", "3g");
		menuItemRepository.save(strawberryPie);

		MenuItem applePie = new MenuItem();
		applePie.setLabel("Apple Pie");
		applePie.setTag("Pies");
		applePie.setDescription("Take a bite from a slice of sweet apple pie, made with a delectable whole grain crust.");
		applePie.setIconUrl("images/products/desserts/applepie.jpg");
		applePie.setPrice(3);
		applePie.setCategory(desserts);
		applePie.setAveragerating(5);
		applePie.setTotalratings(1);
		applePie.setNutritionFacts(new HashMap<>());
		applePie.getNutritionFacts().put("Calories", "134");
		applePie.getNutritionFacts().put("Carbs", "39g");
		applePie.getNutritionFacts().put("Fat", "10g");
		applePie.getNutritionFacts().put("Protein", "3g");
		menuItemRepository.save(applePie);

		MenuItem bananaBread = new MenuItem();
		bananaBread.setLabel("Banana Bread");
		bananaBread.setTag("Banana Based");
		bananaBread.setDescription("Savor a slice of freshly baked banana bread, filled with pecans and served with sugar-free syrup.");
		bananaBread.setIconUrl("images/products/desserts/bananabread.jpg");
		bananaBread.setPrice(3);
		bananaBread.setCategory(desserts);
		bananaBread.setAveragerating(5);
		bananaBread.setTotalratings(1);
		bananaBread.setNutritionFacts(new HashMap<>());
		bananaBread.getNutritionFacts().put("Calories", "89");
		bananaBread.getNutritionFacts().put("Carbs", "26g");
		bananaBread.getNutritionFacts().put("Fat", "6g");
		bananaBread.getNutritionFacts().put("Protein", "11g");
		menuItemRepository.save(bananaBread);

		MenuItem bananaPudding = new MenuItem();
		bananaPudding.setLabel("Banana Pudding");
		bananaPudding.setTag("Banana Based");
		bananaPudding.setDescription("Enjoy a cup of fresh cold and creamy banana pudding.");
		bananaPudding.setIconUrl("images/products/desserts/bananapudding.jpg");
		bananaPudding.setPrice(2.5);
		bananaPudding.setCategory(desserts);
		bananaPudding.setAveragerating(5);
		bananaPudding.setTotalratings(1);
		bananaPudding.setNutritionFacts(new HashMap<>());
		bananaPudding.getNutritionFacts().put("Calories", "213");
		bananaPudding.getNutritionFacts().put("Carbs", "32g");
		bananaPudding.getNutritionFacts().put("Fat", "6g");
		bananaPudding.getNutritionFacts().put("Protein", "2g");
		menuItemRepository.save(bananaPudding);

		MenuItem berryCheesecake = new MenuItem();
		berryCheesecake.setLabel("Berry Cheesecake");
		berryCheesecake.setTag("Cakes");
		berryCheesecake.setDescription("Take a bite of a delectably creamy cheesecake, topped with a sweet berry sauce.");
		berryCheesecake.setIconUrl("images/products/desserts/berrycheesecake.jpg");
		berryCheesecake.setPrice(3);
		berryCheesecake.setCategory(desserts);
		berryCheesecake.setAveragerating(5);
		berryCheesecake.setTotalratings(1);
		berryCheesecake.setNutritionFacts(new HashMap<>());
		berryCheesecake.getNutritionFacts().put("Calories", "297");
		berryCheesecake.getNutritionFacts().put("Carbs", "31g");
		berryCheesecake.getNutritionFacts().put("Fat", "14g");
		berryCheesecake.getNutritionFacts().put("Protein", "8g");
		menuItemRepository.save(berryCheesecake);


		//note sides
		MenuItem spinachAvocadoToast = new MenuItem();
		spinachAvocadoToast.setLabel("Spinach Avocado Toast");
		spinachAvocadoToast.setTag("Snacks");
		spinachAvocadoToast.setDescription("Perfectly toasted bread with a strong spread of avocado, topped with spinach and herbs.");
		spinachAvocadoToast.setIconUrl("images/products/sides/spinachavocadotoast.jpg");
		spinachAvocadoToast.setPrice(1);
		spinachAvocadoToast.setCategory(sides);
		spinachAvocadoToast.setAveragerating(5);
		spinachAvocadoToast.setTotalratings(1);
		spinachAvocadoToast.setNutritionFacts(new HashMap<>());
		spinachAvocadoToast.getNutritionFacts().put("Calories", "102");
		spinachAvocadoToast.getNutritionFacts().put("Carbs", "16g");
		spinachAvocadoToast.getNutritionFacts().put("Fat", "9g");
		spinachAvocadoToast.getNutritionFacts().put("Protein", "4g");
		menuItemRepository.save(spinachAvocadoToast);

		MenuItem strawberryBowl = new MenuItem();
		strawberryBowl.setLabel("Strawberry Bowl");
		strawberryBowl.setTag("Fruit Bowls");
		strawberryBowl.setDescription("A delectable bowl of freshly picked strawberries.");
		strawberryBowl.setIconUrl("images/products/sides/strawberrybowl.jpg");
		strawberryBowl.setPrice(1);
		strawberryBowl.setCategory(sides);
		strawberryBowl.setAveragerating(5);
		strawberryBowl.setTotalratings(1);
		strawberryBowl.setNutritionFacts(new HashMap<>());
		strawberryBowl.getNutritionFacts().put("Calories", "112");
		strawberryBowl.getNutritionFacts().put("Carbs", "12g");
		strawberryBowl.getNutritionFacts().put("Fat", "1g");
		strawberryBowl.getNutritionFacts().put("Protein", "1g");
		menuItemRepository.save(strawberryBowl);

		MenuItem raspberryBowl = new MenuItem();
		raspberryBowl.setLabel("Raspberry Bowl");
		raspberryBowl.setTag("Fruit Bowls");
		raspberryBowl.setDescription("A fresh bowl of delicious raspberries.");
		raspberryBowl.setIconUrl("images/products/sides/raspberrybowl.jpg");
		raspberryBowl.setPrice(1);
		raspberryBowl.setCategory(sides);
		raspberryBowl.setAveragerating(5);
		raspberryBowl.setTotalratings(1);
		raspberryBowl.setNutritionFacts(new HashMap<>());
		raspberryBowl.getNutritionFacts().put("Calories", "65");
		raspberryBowl.getNutritionFacts().put("Carbs", "15g");
		raspberryBowl.getNutritionFacts().put("Fat", "1g");
		raspberryBowl.getNutritionFacts().put("Protein", "1g");
		menuItemRepository.save(raspberryBowl);

		MenuItem watermelonBowl = new MenuItem();
		watermelonBowl.setLabel("Watermelon Bowl");
		watermelonBowl.setTag("Fruit Bowls");
		watermelonBowl.setDescription("A fresh bowl of juicy watermelons slices.");
		watermelonBowl.setIconUrl("images/products/sides/watermelonbowl.jpg");
		watermelonBowl.setPrice(1);
		watermelonBowl.setCategory(sides);
		watermelonBowl.setAveragerating(5);
		watermelonBowl.setTotalratings(1);
		watermelonBowl.setNutritionFacts(new HashMap<>());
		watermelonBowl.getNutritionFacts().put("Calories", "85");
		watermelonBowl.getNutritionFacts().put("Carbs", "17");
		watermelonBowl.getNutritionFacts().put("Fat", "0g");
		watermelonBowl.getNutritionFacts().put("Protein", "2g");
		menuItemRepository.save(watermelonBowl);

		MenuItem cherryBowl = new MenuItem();
		cherryBowl.setLabel("Cherry Bowl");
		cherryBowl.setTag("Fruit Bowls");
		cherryBowl.setDescription("A bowl of freshly picked, sweet, delicious cherries.");
		cherryBowl.setIconUrl("images/products/sides/cherrybowl.jpg");
		cherryBowl.setPrice(1);
		cherryBowl.setCategory(sides);
		cherryBowl.setAveragerating(5);
		cherryBowl.setTotalratings(1);
		cherryBowl.setNutritionFacts(new HashMap<>());
		cherryBowl.getNutritionFacts().put("Calories", "83");
		cherryBowl.getNutritionFacts().put("Carbs", "17");
		cherryBowl.getNutritionFacts().put("Fat", "0g");
		cherryBowl.getNutritionFacts().put("Protein", "1g");
		menuItemRepository.save(cherryBowl);

		MenuItem sweetPotatoFries = new MenuItem();
		sweetPotatoFries.setLabel("Sweet Potato Fries");
		sweetPotatoFries.setTag("Snacks");
		sweetPotatoFries.setDescription("A small plate of crispy seasoned sweet potato fries.");
		sweetPotatoFries.setIconUrl("images/products/sides/sweetpotatofries.jpg");
		sweetPotatoFries.setPrice(1.5);
		sweetPotatoFries.setCategory(sides);
		sweetPotatoFries.setAveragerating(5);
		sweetPotatoFries.setTotalratings(1);
		sweetPotatoFries.setNutritionFacts(new HashMap<>());
		sweetPotatoFries.getNutritionFacts().put("Calories", "115");
		sweetPotatoFries.getNutritionFacts().put("Carbs", "21g");
		sweetPotatoFries.getNutritionFacts().put("Fat", "5g");
		sweetPotatoFries.getNutritionFacts().put("Protein", "1g");
		menuItemRepository.save(sweetPotatoFries);

		MenuItem macncheese = new MenuItem();
		macncheese.setLabel("Low-Fat Mac And Cheese");
		macncheese.setTag("Snacks");
		macncheese.setDescription("Have a guilt-free bowl of delicious, low-fat mac and cheese.");
		macncheese.setIconUrl("images/products/sides/macncheese.jpg");
		macncheese.setPrice(1.5);
		macncheese.setCategory(sides);
		macncheese.setAveragerating(5);
		macncheese.setTotalratings(1);
		macncheese.setNutritionFacts(new HashMap<>());
		macncheese.getNutritionFacts().put("Calories", "224");
		macncheese.getNutritionFacts().put("Carbs", "22g");
		macncheese.getNutritionFacts().put("Fat", "0g");
		macncheese.getNutritionFacts().put("Protein", "13g");
		menuItemRepository.save(macncheese);




		Account acc = new Account();
		acc.setName("John Doe");
		accountRepository.save(acc);

		ProductRating rating = new ProductRating();
		rating.setRating(5);
		rating.setMessage("This pizza was absolutely delectable, and I was able to enjoy it guilt free as well!");
		rating.setReviewer(acc);
		rating.setProduct(crispyMediterraneanPizza);
		productRatingRepository.save(rating);

		ProductRating rating2 = new ProductRating();
		rating2.setRating(5);
		rating2.setMessage("I've never normally seen this type of thing at vegetarian restaurants, but it was delicious!");
		rating2.setReviewer(acc);
		rating2.setProduct(eggBreakfastSandwich);
		productRatingRepository.save(rating2);

		ProductRating rating3 = new ProductRating();
		rating3.setRating(3);
		rating3.setMessage("The recyclable packaging didn't fare well when I spilled my drink. Still, it was an overall solid experience.");
		rating3.setReviewer(acc);
		rating3.setProduct(bananaPudding);
		productRatingRepository.save(rating3);

		ProductRating rating4 = new ProductRating();
		rating4.setRating(5);
		rating4.setMessage("These cherries are divine, and I would die for them.");
		rating4.setReviewer(acc);
		rating4.setProduct(cherryBowl);
		productRatingRepository.save(rating4);



		RestaurantRating restRating = new RestaurantRating();
		restRating.setReviewer(acc);
		restRating.setRating(5);
		restRating.setMessage("My experience with Condelu has been nothing but fabulous!");
		restaurantRating.save(restRating);

		RestaurantRating restRating2 = new RestaurantRating();
		restRating2.setReviewer(acc);
		restRating2.setRating(5);
		restRating2.setMessage("10/10, I would recommend eating here to any of my friends.");
		restaurantRating.save(restRating2);

		RestaurantRating restRating3 = new RestaurantRating();
		restRating3.setReviewer(acc);
		restRating3.setRating(5);
		restRating3.setMessage("Are there any better vegetarian restaurants? I didn't think so.");
		restaurantRating.save(restRating3);

		RestaurantRating restRating4 = new RestaurantRating();
		restRating4.setReviewer(acc);
		restRating4.setRating(5);
		restRating4.setMessage("Did you know they deliver? Not only is the food great, but it's also convenient!");
		restaurantRating.save(restRating4);

		RestaurantRating restRating5 = new RestaurantRating();
		restRating5.setReviewer(acc);
		restRating5.setRating(5);
		restRating5.setMessage("I really appreciate how Condelu goes out of its way to use sustainable packaging.");
		restaurantRating.save(restRating5);


		RestaurantLocation location1 = new RestaurantLocation();
		location1.setAddressLine("1234 Lorem Ipsum Lane");
		location1.setCity("Mars");
		location1.setState("Texas");
		location1.setZipCode("99999");
		restaurantLocationRepository.save(location1);

		RestaurantLocation location2 = new RestaurantLocation();
		location2.setAddressLine("4321 Amazing Road");
		location2.setCity("Luna");
		location2.setState("Texas");
		location2.setZipCode("99999");
		restaurantLocationRepository.save(location2);
	}


}
