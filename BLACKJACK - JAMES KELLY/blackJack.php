<div align="center">

<body style=
"background-color:#003390;
font-family:Times New Roman;
font-size:110%;
color:white;
">

<h1 style="color:white;
background-color: red;
padding: 10px 20px;">BlackJack</h1>
<h3 style=
    "background-color: #ffffff;
    border: none;
    color: black;
    padding: 10px 20px;
    font-family:Times New Roman;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;">
    BET : <input type="text" name="BET" value=" "></h3>
<style>
.button {
  background-color: #000000;
  border: none;
  color: white;
  padding: 10px 20px;
  font-family:Times New Roman;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 2px 0px;
  cursor: pointer;
}
.button:hover{
  background-color:#009999;
}

img { padding: 2px;}
</style>
<?php
  session_start();
 
/*  echo '<br>Session count = ' . count($_SESSION);
  echo '<pre>';
  print_r($_SESSION);
  echo '</pre>';*/
  if ( count($_SESSION) == 0 )  {
      dealCards();
  }
  
  // function called at the start of the game 
  // the dealer and the player get two cards each
  // only called at start of the game
  function dealCards() {
    global  $dCardCount;
    // need to check for duplicates
    //echo '<br> Session array is empty !!';

    do{ 
        
        echo"<br>DEALER'S CARD<br>";
        $dCard1 = $_SESSION['$dCard1'] = rand(1,52);
        displayCard($_SESSION['$dCard1']);
        $dCard2 = $_SESSION['$dCard2'] = rand(1,52);
        displayCard($_SESSION['$dCard2']);
       
        echo "<br>~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        echo"<br>PLAYER'S CARD <br>";
        $pCard1 = $_SESSION['$pCard1'] = rand(1,52);
        displayCard($_SESSION['$pCard1']);
        $pCard2 = $_SESSION['$pCard2'] = rand(1,52);
        displayCard($_SESSION['$pCard2']);
       

        $dCardCount =2;
    }while ( $pCard1 == $pCard2 );  
    $_SESSION['$pCardCount'] = 2; 
    $_SESSION['$dCardCount'] = 2; 
  }

  function playerScore() {

    $count = 1; $ptotal = 0; $cardValue = 0;

    while ($count <= $_SESSION['$pCardCount'] ) {
        // session variable $pCard . $count
        $current = '$pCard' . $count;
        $cardValue = $_SESSION[$current] % 13;
        // check face cards king returns 0 , jack = 11 , queen 12
        if ( ($cardValue % 13 == 0)  ||  ($cardValue % 13) > 10  ) 
        { 
            $cardValue = 10;
        } 
        $ptotal += $cardValue;

        
       // echo '<br> PLAYER card ' . $count ;
        echo '<br> PLAYER total = ' . $ptotal.'<br>';
        $count++;

        if($ptotal==21)
        {
          echo "<br>Winner Winner, Chicken Dinner , YOU GOT 21";
        }
        
        elseif($ptotal>21)
        {
          echo "<br>Mission Failed ,We'll Get The DEALER Next Time";    
        }

        elseif(isset($_POST['stay']) )
       {  
        echo "##STAYING WITH ".$ptotal."##<br>";
        
       }
       
          
      }
    
  }

  
  function DealerScore() {

    $count = 1; $dtotal = 0; $cardValue = 0;

    while ($count <= $_SESSION['$dCardCount'] ) {
        // session variable $dCard . $count
        $current = '$dCard' . $count;
        $cardValue = $_SESSION[$current] % 13;
        // check face cards king returns 0 , jack = 11 , queen 12
        if ( ($cardValue % 13 == 0)  ||  ($cardValue % 13) > 10  ) 
        { 
            $cardValue = 10;
        } 
        $dtotal += $cardValue;
       // echo '<br> PLAYER card ' . $count ;
        echo '<br> DEALER total = ' . $dtotal.'<br>';
        $count++;
      }
    
  }

  
  // give the player another card
  // check for duplicate and total card count < 5
  function DealerGetCard() {
    
    if ($_SESSION['$dCardCount'] < 5) {
        $_SESSION['$dCardCount'] = $_SESSION['$dCardCount'] + 1;
        $card = '$dCard' . $_SESSION['$dCardCount'];  
        //echo '<br>card going into the array is ' . $card;
        $_SESSION[$card] = rand(1,52);
         echo"<br>"; 
         //bet(); 
         dealerScore();
         displayDealerCards();
         echo "<br>~~~~~~~~~~~~~~~~~~~~~~~~~~~";
         //bet();
    }
  }
 
  function playerGetCard() {
    
    if ($_SESSION['$pCardCount'] < 5) {
        $_SESSION['$pCardCount'] = $_SESSION['$pCardCount'] + 1;
        $card = '$pCard' . $_SESSION['$pCardCount'];  
        //echo '<br>card going into the array is ' . $card;
        $_SESSION[$card] = rand(1,52);
         echo"<br>"; 
         displayPlayerCards();
         playerScore();
        // bet();
    }

  
  }
    // function : displayPlayerCards
 // description: display all the players current cards on screen
 function displayPlayerCards() {
  $count = 1;
  echo "<br>PLAYER'S CARD<br>";
  while ($count  <= $_SESSION['$pCardCount']) {
   $currentCard = '$pCard' . $count;
  
   echo "<img src='" .  $_SESSION[$currentCard] .".png'>";
  
   $count++;
  }
 }
      // function : displayPlayerCards
 // description: display all the players current cards on screen
 function displayDealerCards() {
  $count = 1;
  echo "<br>DEALER'S CARD<br>";
  while ($count  <= $_SESSION['$dCardCount']) {
   $currentCard = '$dCard' . $count;
  
   echo "<img src='" .  $_SESSION[$currentCard] .   ".png'>";
  
   $count++;
  }

}

  
    
 
  function displayCard($picNum)
  {
    $img =  $picNum . '.png' ;

    //echo "And the image is " . $img . '<br>';
    echo "<img src='" . $img .   "'>";
  
  }

 /* function bet()
  {
   $bank=1000;//complementary 10 euro
     echo '<br>Bank:'.$bank;
       $b=$bank-$_SESSION[$_POST['BET']];
      echo "<br>1 BET PER GAME <br>BANK: ".$b;
  }
  */

  echo '<br>';

   if (isset($_POST['hit']) )
   {
     //  echo '<br> get another card';
     DealerGetCard();
    
     playerGetCard();   
   }

   /*if (isset($_POST['clear']) )
   {
      // echo '<br>clear the session array ';
    session_unset();
   }*/
   if (isset($_POST['newgame']) )
   {
      //  echo '<br>clear the session array for new game ';
        session_unset();
        dealCards();
        playerScore(); 
      
    }

    if (isset($_POST['BET']) )
    {
      
     bet(); 
     
     }
     
     
     if (isset($_POST['stay']) )
    {
      dealerScore();
      echo "~~~~~~~~~~~~~~~~~~~~~~~~~~~";
      playerScore();
      
     }
   


?>
 
 <form action="blackJack.php" method="post">
  <!-- <input type="submit" value='Hit'> <input type="reset">-->
  <center>
    <button class="button" type="submit" name="newgame" value="newgame">NEW GAME</button>
    <button class="button" type="submit" name="hit" value="HIT">HIT</button>
    <button class="button" type="submit" name="stay" value="STAY">STAY</button>
    <p>
 
     
 </center>
 </div>
 
 <footer style= "color:white;
background-color: red;
">
     <center> <h3 style=
     "color:white;
background-color: black;
padding: 10px 20px;"
     >HOW TO PLAY:</h3></center>
     
      <ul>
        <h5>
            <li>Blackjack will be played with one a deck of 52-cards.</li>
            
            <li>Aces may be counted as 1 or 11 points, 2 to 9 according to pip value,
                 and tens and face cards count as ten points.</li>
            
             <li>The value of a hand is the sum of the point values of the individual cards. Except, a "blackjack" is the highest hand, consisting of an ace and any 10-point card,
                 and it outranks all other 21-point hands</li>
                 
            <li>After the players have bet, the dealer will give two cards to each player and two cards to himself.
                 One of the dealer cards is dealt face up. 
                The facedown card is called the "hole card."</li>
            
             <li>If the dealer has an ace showing, he will offer a side bet called "insurance." This side wager pays 2 to 1 if the dealer's hole card is any 10-point card.
                  Insurance wagers are optional and may not exceed half the original wager.</li>
            
             <li>If the dealer has a ten or an ace showing (after offering insurance with an ace showing), then he will peek at his facedown card to see if he has a blackjack. 
                 If he does, then he will turn it over immediately.</li>
            
             <li>If the dealer does have a blackjack, then all wagers (except insurance) will lose,
                  unless the player also has a blackjack, which will result in a push. 
                 The dealer will resolve insurance wagers at this time.</li><br>
                </ul> 
                <h5>
    
             
