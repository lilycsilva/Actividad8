public class Main {
    public static void main(String[] args)
    {
        Deck a;
        Card[] hand = new Card[5];
        int i;

        a = new Deck();
        System.out.println("Deck: ");
        System.out.println(a);

        //Head
        Card head;
        head = a.deal();
        System.out.println("Head: " +head);
        System.out.println("Quedan 51 cartas en deck. \n");

        //Shuffle
        System.out.println("Shuffle. Se mezcló el Deck: ");
        a.shuffle(1000);
        System.out.println(a);

        //Pick
        Card pick;
        pick = a.deal();
        System.out.println("Pick: " +pick);
        System.out.println("Quedan 50 cartas en deck. \n");

        //Hand
        for ( i = 0; i < 5; i++ )
        {
            hand[i] = a.deal();
        }

        System.out.print("Hand: ");
        for ( i = 0; i < 5; i++ )
            System.out.print(hand[i] + "  ");
        System.out.println();
        System.out.println("Quedan 45 cartas en el Deck. \n");

        System.out.println("NOTA: Los diamantes 'd' y los corazones 'c' son color rojo y los treboles 't' y las picas 'p' son color negro.");
    }
}

//Deck
class Deck
{
    public static final int NCARDS = 52;

    private Card[] deckOfCards;         // Contiene las 52 cartas
    private int currentCard;

    public Deck( )
    {
        deckOfCards = new Card[ NCARDS ];

        int i = 0;

        for ( int palo = Card.DIAMANTES; palo <= Card.PICAS; palo++ )
            for ( int valor = 1; valor <= 13; valor++ )
                deckOfCards[i++] = new Card(palo, valor);

            currentCard = 0;
    }

       //Shuffle del deck
    public void shuffle(int n)
    {
        int i, j, k;

        for ( k = 0; k < n; k++ )
        {
            i = (int) ( NCARDS * Math.random() );  // Elige 2 cartas al azar
            j = (int) ( NCARDS * Math.random() );  // en el deck

	     //swap de las cartas elegidas al azar
            Card tmp = deckOfCards[i];
            deckOfCards[i] = deckOfCards[j];
            deckOfCards[j] = tmp;
        }

        currentCard = 0;
    }

       //Deal deckOfCards[currentCard] out - Remover la carta del deck
    public Card deal()
    {
        if ( currentCard < NCARDS )
        {
            return ( deckOfCards[ currentCard++ ] );
        }
        else
        {
            System.out.println("Out of cards error");
            return ( null );  // Error
        }
    }


    public String toString()
    {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += (deckOfCards[k++] + " ");

            s += "\n";
        }
        return ( s );
    }
}

class Card
{
    public static final int PICAS   = 4;
    public static final int CORAZONES   = 3;
    public static final int TREBOLES    = 2;
    public static final int DIAMANTES = 1;

    private static final String[] Palo = { "*", "d", "t", "c", "p"};
    private static final String[] Valor = { "*", "*", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    private byte cardPalo;
    private byte cardValor;

    public Card( int palo, int valor )
    {
        if ( valor == 1 )
            cardValor = 14;     // Dar a As el valor 14
        else
            cardValor = (byte) valor;

        cardPalo = (byte) palo;
    }

    public int palo()
    {
        return ( cardPalo );
        //   this.cardPalo
    }

    public String paloStr()
    {
        return( Palo[ cardPalo ] );
        //   this.Palo[ this.cardPalo ]
    }

    public int valor()
    {
        return ( cardValor );
    }

    public String valorStr()
    {
        return ( Valor[ cardValor ] );
    }

    public String toString()
    {
        return ( Valor[ cardValor ] + Palo[ cardPalo ] );
    }
}