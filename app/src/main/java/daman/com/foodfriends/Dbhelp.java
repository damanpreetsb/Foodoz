package daman.com.foodfriends;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.util.Log;


/**
 * Created by DELL on 09-May-16.
 */
public class Dbhelp extends SQLiteOpenHelper {

    public static final String DB_NAME = "fooddb";
    public static final int DB_VERSION = 2;

    public Dbhelp(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS FOODTABLE");

        try {
            db.execSQL("CREATE TABLE FOODTABLE ("
                    + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + "NAME TEXT, "
                    + "DESCRIPTION TEXT, "
                    + "CATEGORY TEXT ); ");
            FoodAsyncTask ci = new FoodAsyncTask(db);
            ci.execute();
            Log.i("DATABASE ASYNCTASK", "Database created!");
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS FOODTABLE");
        onCreate(db);
    }


    private static void insertFood(SQLiteDatabase db, String name,
                                   String description, String category) {
        ContentValues foodList = new ContentValues();
        foodList.put("NAME", name);
        foodList.put("DESCRIPTION", description);
        foodList.put("CATEGORY", category);
        db.insert("FOODTABLE ", null, foodList);
    }

    private class FoodAsyncTask extends AsyncTask<Void, Void, Void> {

        SQLiteDatabase sqLiteDatabase;

        public FoodAsyncTask(SQLiteDatabase sqLiteDatabase) {
            this.sqLiteDatabase = sqLiteDatabase;
        }

        @Override
        protected Void doInBackground(Void... nulls) {
            insertFood(sqLiteDatabase, "Punjabi By Nature", "Specialty: Duplex restaurant, with a bar on the top floor.\n" +
                    "\n" +
                    "What to have: Raan-e-Punjab or the roast leg of lamb, vodka golgappas (fried crispy dough balls filled with flavoured and spiced vodka)\n" +
                    "\n" +
                    "Serves alcohol: Yes\n" +
                    "\n" +
                    "Budget for 2: Rs 2000\n" +
                    "\n" +
                    "Location: 11 PVR Priya Cinema Complex, Basant Lok, Vasant Vihar, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Moti Mahal", "Specialty: One of the heritage North Indian restaurants of Delhi\n" +
                    "\n" +
                    "What to have: Butter Chicken, Murg Masallam, Kadhai Paneer\n" +
                    "\n" +
                    "Serves alcohol: No\n" +
                    "\n" +
                    "Budget for 2: Rs 1100\n" +
                    "\n" +
                    "Location: 3703, Netaji Subhash Marg, Daryaganj, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Punjabi Haveli", "Specialty: Live music, especially ghazals; hukkas also available.\n" +
                    "\n" +
                    "What to have: Paneer Kundan Kalia, Murgh Kali Mirch, Pindi Channa\n" +
                    "\n" +
                    "Serves alcohol: Yes\n" +
                    "\n" +
                    "Budget for 2: Rs 500\n" +
                    "\n" +
                    "Location: HL 1&2, Hari Nagar Depot Crossing, Jail Road, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Pind Balluchi", "Specialty: Food is served in traditional Punjabi style copper thalis.\n" +
                    "\n" +
                    "What to have: Dal Makhani, Pindi Chhole, Mushroom Kurkure\n" +
                    "\n" +
                    "Serves alcohol: Yes\n" +
                    "\n" +
                    "Budget for 2: Rs 900\n" +
                    "\n" +
                    "Location: J2/1 BK Dutta Market, Rajouri Garden, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Dhaba", "Specialty: Restaurant decor is keeping in line with rustic Indian aesthetics.\n" +
                    "\n" +
                    "What to have: Butter Chicken\n" +
                    "\n" +
                    "Serves alcohol: No\n" +
                    "\n" +
                    "Budget for 2: Rs 900\n" +
                    "\n" +
                    "Location:  A 5, Vishal Enclave, Main Najafgarh Road, Rajouri Garden, New Delhi.\n" +
                    "\n", "PUNJABI");
            insertFood(sqLiteDatabase, "Khalsa", "Specialty: Delicious Punjabi food at pocket-friendly rates; thali options available.\n" +
                    "\n" +
                    "What to have: Liver Dana Tikka, Tangri Kebabs\n" +
                    "\n" +
                    "Serves alcohol:  No\n" +
                    "\n" +
                    "Budget for 2: Rs 500\n" +
                    "\n" +
                    "Location:  50 & 51, New Janta Market, Club Road, Paschim Puri Chowk, Punjabi Bagh, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Wah Ji Wah", "Specialty: Budget-friendly vegetarian Punjabi food.\n" +
                    "\n" +
                    "What to have: Soya Chaap\n" +
                    "\n" +
                    "Serves alcohol: No\n" +
                    "\n" +
                    "Budget for 2: Rs 500\n" +
                    "\n" +
                    "Location: 11, C S C, DDA Market, A 2 Block, Paschim Vihar, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Punjabi Rasoi", "Specialty: Long-standing restaurant serving traditional vegetarian Punjabi cuisine.\n" +
                    "\n" +
                    "What to have: Dal Makhani, Butter Paratha, Butter Paneer Masala\n" +
                    "\n" +
                    "Serves alcohol: No\n" +
                    "\n" +
                    "Budget for 2: Rs 500\n" +
                    "\n" +
                    "Location: 351, Aggarwal Center Plaza, DC Chowk, Sector 9, Rohini, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Privilege Punjab", "Specialty: Special buffet lunches available; Good choice for party bookings.\n" +
                    "\n" +
                    "What to have: Chicken Lababdar, Palak Paneer, Aloo Kulcha\n" +
                    "\n" +
                    "Serves alcohol: Yes\n" +
                    "\n" +
                    "Budget for 2: Rs 1000\n" +
                    "\n" +
                    "Location:  A-12 Vishal Enclave, Main Nazafgarh Road, Rajouri Garden, New Delhi.", "PUNJABI");
            insertFood(sqLiteDatabase, "Not Just Paranthas", "Specialty: Innovative and quirky parantha recipes; a popular restaurants amongst youngsters of Delhi.\n" +
                    "\n" +
                    "What to have: Varki Paratha, Sharabi Paratha\n" +
                    "\n" +
                    "Serves alcohol: No\n" +
                    "\n" +
                    "Budget for 2: Rs 1200\n" +
                    "\n" +
                    "Location: M 84, M Block Market, Greater Kailash (GK) 2, New Delhi.", "PUNJABI");

            insertFood(sqLiteDatabase, "Carnatic Café, New Friends Colony", "This small and simple restaurant offers home-style cuisine from Karnataka. There are the better-known dishes like curd rice and vadas, and also some traditional fare that one often doesn’t see in other parts of the country. The interiors are intimate, and little decorations of paper cutouts and puppets are characteristic of Karnataka.\n" +
                    "\n" +
                    "Cost for two - Rs 400 approx.\n" +
                    "Contact: 011 4100 8630" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Dakshin, Saket", "Authenticity, variety and flavour – Dakshin scores high on all of these when it comes to South Indian cuisine. They use ingredients that come straight from their sources in South India and some of their most popular dishes are the deep-fried prawns, Andhra mutton curry and fried sole fish.\n" +
                    "\n" +
                    "Cost for two - Rs 2700 approx.\n" +
                    "Contact: 011 33106191" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Andhra Pradesh Bhawan Canteen, Ashoka Road", "Lightening-speed servers and waves of hungry customers who keep coming back for the quality and affordability are the hallmarks of the canteen at Andhra Bhawan. Don’t be intimidated by the bustle, because you are given a guarantee that you will be seated and served a great meal, all in just 30 minutes. They do not provide home delivery.\n" +
                    "\n" +
                    "Cost for two - Rs 200 approx." , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "The Toddy Shop, Hauz Khas Village", "Serving up a variety of South Indian fare from Tamil Nadu to Andhra Pradesh, The Toddy shop has excellent food and the service is spot on. They have a variety of large-sized dosas on the menu, and these can be a meal in themselves. Reservations are recommended.\n" +
                    "\n" +
                    "Cost for two - Rs 1000 approx.\n" +
                    "Contact: +91 9560256426/ 011 40519338" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Swagath, Defence Colony", "Known for dishes like Chicken Malabari and Kadi Patta Prawns, Swagath in Defence Colony offers you a meal for two for a moderate price. The servers are always courteous and incidentally, the place also has North Indian and Chinese food on the menu.\n" +
                    "\n" +
                    "Cost for two - Rs 1500 approx.\n" +
                    "Contact: 011 24330930 / 011 24337538" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Naivedyam, Hauz Khas", "Located at Hauz Khas Village, Naivedyam serves Udipi cuisine and is among the best restaurants in delhi offering South Indian meals. The first thing you’re served when you get here is a bowl of rasam. Then you can choose from the many vegetarian Udipi favourites on the menu. The great part is that the prices are nominal. Naivedyam accepts reservations.\n" +
                    "\n" +
                    "Cost for two - Rs. 400 approx.\n" +
                    "Contact: 011 26960426" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Karnataka Food Centre, RK Puram", "Don’t be surprised to see a long line outside this down to earth eatery. Known for its authentic South Indian food, Karnataka Food Centre is equally popular for its prompt and polite service. The Mangalorean-style sambhar never disappoints and the chutneys are delectable.\n" +
                    "\n" +
                    "Cost for two - Rs 300 approx.\n" +
                    "Contact: 011 26187357" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Hotel Saravana Bhawan, Connaught Place", "Located in the heart of Delhi, Hotel Saravana Bhawan is a reliable bet if you’re in the mood for something South Indian. With unlimited sambhar and chutneys, this place is always packed.\n" +
                    "\n" +
                    "Cost for two - Rs 400 approx.\n" +
                    "Contact: 011 28844305" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Sagar Ratna, Connaught Place", "An old favourite of many Delhiites, Sagar Ratna is as authentically South Indian as it gets. The ambience is comfortable and the food is fulfilling. You won’t mind the no-frills straight seating arrangement here, because the cuisine is the star! It can get quite packed especially on weekends.\n" +
                    "\n" +
                    "Cost for two - Rs 450 approx.\n" +
                    "Contact: 011 23412470" , "SOUTH INDIAN");
            insertFood(sqLiteDatabase, "Farzi Café, DLF Cyber City, Gurgaon", "This is not an exclusively South Indian restaurant, but the excellent food quality and flavour earns it a spot on the list. The swanky interiors are done up in glass, wood and wrought iron and the complimentary cotton candy paan at the end of the meal is a nice touch!\n" +
                    "\n" +
                    "Cost for two - Rs 1500 approx.\n" +
                    "Contact: 0124 4922273" , "SOUTH INDIAN");

            insertFood(sqLiteDatabase, "Shraman - The Ashok", "CUISINES:\tPure Veg, Rajasthani, North Indian, Gujarati\n" +
                    "COST FOR TWO:\t₹1,800\n" +
                    "HOURS:\t11 AM to 11 PM\n" +
                    "FEATURED IN:\t\n" +
                    "Veggie Friendly", "GUJRATI");
            insertFood(sqLiteDatabase, "Suruchi", "CUISINES:\tPure Veg, Gujarati, Rajasthani, North Indian\n" +
                    "COST FOR TWO:\t₹700\n" +
                    "HOURS:\t11 AM to 11 PM", "GUJRATI");
            insertFood(sqLiteDatabase, "Panchavati Gaurav", "CUISINES:\tPure Veg, Gujarati, Rajasthani\n" +
                    "COST FOR TWO:\t₹1,000\n" +
                    "HOURS:\t12 Noon to 3:30 PM, 6:30 PM to 10:30 PM", "GUJRATI");

            insertFood(sqLiteDatabase, "Paranthe Wali Gali", "Located in the Chandni Chowk area of New Delhi, the Paranthe wali gali as the name suggests is renowned for the huge number of shops selling paratha that is a fried Indian bread. Note that the parathas are strictly vegetarian! The parathas are very budget-friendly and you can eat to your taste buds content!", "STREET FOOD");
            insertFood(sqLiteDatabase, "Lala Babu Chaat Bhandar", "If authentic chat is the need of the hour then Lala Babu Chaat Bhandaar is the perfect place to head to. Located in the Chandni Chowk, bang opposite McDonalds this chat stall one to saviour. The Gobi muttar samosas are a must try and at Rs. 80 for two people, definitely no one will be complaining.", "STREET FOOD");
            insertFood(sqLiteDatabase, "Bishan Swaroop", "One of the hidden gems of Chandni Chowk is Bishan Swaroop. Located on the unruly side streets of Chandni Chowk, this place is totally worth the effort put in finding it. The average cost for two is a meager Rs. 50 for two people! The fruit chaat & aloo kulla (scooped out boiled potato and having the filling of chickpeas with the garnishing of spices and lemon) is totally mouth watering!", "STREET FOOD");
            insertFood(sqLiteDatabase, "Shree Balaji Chaat Bhandar", "The list of popular chaat places is incomplete without mentioning Shree Balaji Chaat Bhandar. One of the best chaat places in Old Delhi, Shree Balaji Chaat Bhandar is popular amongst everyone. The array of snacks is quite extensive and at an average cost RS. 80 for two, this place is just too good. The papri chaat is a must try for everyone who visits here.", "STREET FOOD");
            insertFood(sqLiteDatabase, "Khandani Pakode wala", "There is nothing better than munching on pakodas and sipping on tea during the winters. The Khandani Pakode wala in Sarojini Nagar Ring Road Market is heaven for those who love to gorge on some pakodas. The outlet dishes out 10 types of pakodas at any given time. The bread pakoda and the Paneer pakodas are the hottest properties at this outlet and the chutneys that come along are just an icing on them. The price for these lovely pakodas is in the range of 10 to 12 rupees only!", "STREET FOOD");
            insertFood(sqLiteDatabase, "Kulcha King", "Exactly opposite Khandani Pakode wala is the Kulcha King. Serving some amazing Amritsari Kulcha and chole, the place leaves you craving for more! For people who want to have a look at the amazing stuff in store before you visit, the place also has its website, www.kulchakingfood.com . Ranging from 70 Rs. To 100 Rs. your taste buds will definitely be satisfied!", "STREET FOOD");
            insertFood(sqLiteDatabase, "Prince’s Paan & Chaat Corner", "Not everyone would be comfortable to delve deep in to the by lanes of Chandni Chowk, to satisfy the taste buds of such individuals Prince’s Paan & Chaat Corner is the solution. The apt up-market place for those who want to taste delicious street food in Delhi without venturing much. Owing to its location in the posh Greater Kailash I, this place has got great expats visiting it. The cost is steep at Rs. 250 for two but so is the taste!", "STREET FOOD");

            return null;

        }

    }
}