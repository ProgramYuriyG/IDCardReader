import java.util.*;
public class Homework2{

//Creates the array for available items and price
public static String [] availableItems = {"bookbag", "textbook", "notebook", "pen", "pencil", " sweatpants", "shirt", "sweater", "candy", "planner"};
public static int [] availableItemsPrice = {40, 50, 3, 1, 1, 35, 25, 30, 2, 15};

//Main method
public static void main(String[]args){
Scanner input = new Scanner(System.in);

//asks the user for their CSU Viking Card ID
System.out.println("What is your CSU VIking card ID: ");
int csuVikingCard = input.nextInt();

//checks the validity of the id
if(csuVikingCard<40000 || csuVikingCard>89999){
System.out.println("You entered an invalid CSU Viking Card ID");
}

//asks the user to enter a valid ID
while(csuVikingCard<40000 || csuVikingCard>89999){
System.out.println("Please Enter a valid ID");
csuVikingCard = input.nextInt();
}

//asks user how many items they will be purchasing
int a = 0;
System.out.println("How many items will you be purchasing?");
int itemsPurchasing = input.nextInt();
String blankLine = input.nextLine();
//checks if purchasing amount is between 1 and 10
while(a==0){
   if(itemsPurchasing >10 || itemsPurchasing <1){
   System.out.println("You can not purchase "+itemsPurchasing+" items.");
   System.out.println("\nHow many items will you be purchasing?");
   itemsPurchasing = input.nextInt();
   blankLine = input.nextLine();
   continue;
   }else{
   a = 1;
   }
}

//Gets the Discount Rate Percentage
int discountRate = 0;
if(csuVikingCard >= 80000){
discountRate = 5;
}else if(csuVikingCard >= 60000){
discountRate = 15;
}else{
discountRate = 20;
}

//creates an array for the items purchased
String [] itemsPurchasedList = new String[itemsPurchasing];

//while the items entered does not reach the stated amount, keep asking for items
int y = 0;
int validity = 0;

while(y < itemsPurchasing){
validity = 0;
//asks the user for what they are purchasing
System.out.println("What will you be purchasing?");
String itemsPurchased = input.nextLine();

//Checks to see if it is a valid item
validity = PurchaseValidity(itemsPurchased);
if(validity == 1){
continue;
}

//puts the item purchased into the array index
itemsPurchasedList[y] = itemsPurchased.toLowerCase();
y++;

}

//Gets the price total
int priceTotal = 0;
double priceTotalDiscount = 0;
priceTotal = GetPrice(itemsPurchasedList);
priceTotalDiscount = DiscountPrice(priceTotal,discountRate);

//prints out the list of items purchased
System.out.print("\nYou ordered the following: ");
for(int i=0;i<itemsPurchasedList.length;i++){
if(i == itemsPurchasedList.length-1){
System.out.print(itemsPurchasedList[i]+"");
}else{
System.out.print(itemsPurchasedList[i]+", ");
}
}

//Prints out the gross price, discount rate, and net total
System.out.println();
System.out.println("Gross Total: " + "$" + priceTotal);
System.out.println("Discount: " + discountRate + "%");
System.out.println("Net Total: " + "$" + priceTotalDiscount);
}

public static int  PurchaseValidity(String purchasedItem){
//checks to see if input was valid

//makes the lowercase of the input
String item = purchasedItem.toLowerCase();

//makes a loop to check if the input matches one of them
for(int x=0;x<availableItems.length;x++){
   if( item.equals(availableItems[x]) ){
   return 0;
   }else{
   continue;
   }
}

//returns that the item is not sold here if it is not one of the array values
System.out.println("Item entered is not sold here.\n");
return 1;
}


//Gets the price for the item
public static int GetPrice(String [] item){

//initialize price total
int priceTotal = 0;

for(int a=0;a<item.length;a++){
   for(int x=0;x<availableItems.length;x++){
      if( item[a].equals(availableItems[x]) ){
      priceTotal += availableItemsPrice[x];
      }else{
      continue;
      }
   }
}

return priceTotal;
}


public static double DiscountPrice(int priceTotal, int discountRate){

//sets the rate to a decimal
double discountDecimal = (double)discountRate/100.0;

//Sets the new discounted price
double discountPrice = (double)priceTotal - ((double)priceTotal*discountDecimal);

return discountPrice;
}
}




