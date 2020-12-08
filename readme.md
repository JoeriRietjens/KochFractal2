    # Processed and Threads      
    ## Opdracht
    ### 1.
    level 8 : 6ms
    level 9 : 22ms
    level 10 : 68ms

    ### 2.
    Zie applicatie.

    ### 3.
    NullPointerException:
    Steeds als de applicatie een level omhoog gaat wijzigt hij bepaalde edges.
    Als deze niet bestaat en hij probeert deze te tekenen dan weet hij niet meer wat hij moet doen.
    Daarom geeft hij een NullPointerException.

    ### 4.
    level 8 : 7ms
    level 9 : 18ms
    level 10 : 62ms
    
    # Synchronisation
    Deadlock: Een situatie waarbij 2 of meerde threads op elkaar wachten tot ze klaar zijn,
    en hierdoor dus vast lopen.
    Livelock: Een situatie waarbij een threads actie verantwoordelijk is voor de actie van een andere thread.
    Thread 1 reageerd op de actie van thread 2 en visa versa. 
    In tegenstelling to een deadlock blijven beide threads draaien maar komen ze niet verder. 
    Ze draaien dus in een oneindige loop.
    Starvation: Een situtatie waarbij een tread op een andere thread klaar is maar voordat dit is,
    wordt de thread al weer aangeroepen door een andere thread. Hij wordt dus altijd overgeslagen.
    
    #GUI Aspects
    ###1.
    Vorige week in de synchornisatie opdracht had ik het al zo gemaakt dat deze de edges
    naar de kochmanager stuurt. Hierbij heb ik dus de singleresponsibility verbeterd.
    Edge is het subject van de Kochmanager. Wat de observer is.
    ###2.
    