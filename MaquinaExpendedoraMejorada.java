public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // el numero de billetes vendidos
    private int numeroDeBilletesVendidos;
    //
    private int cantidadDeBilletesQueQuedanPorVenderParaDarElPremio;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //
    private boolean imprimirBilletesConPremio;
    //
    private int numMaxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean billetesConPremio, int enterNumMaxBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numeroDeBilletesVendidos = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        imprimirBilletesConPremio = billetesConPremio;
        numMaxBilletes = enterNumMaxBilletes;
        cantidadDeBilletesQueQuedanPorVenderParaDarElPremio = 3;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroDeBilletesVendidos < numMaxBilletes) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println (cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("Error: NO SE PUEDE IMPRIMIR MÁS BILLETES");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroDeBilletesVendidos < numMaxBilletes) {
            if (cantidadDeDineroQueFalta <= 0) { 

                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("# CantidadDeDineroQueFalta: " + cantidadDeDineroQueFalta);
                System.out.println("##################");       

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Calcula el numero de billetes
                numeroDeBilletesVendidos = numeroDeBilletesVendidos + 1;
                //
                cantidadDeBilletesQueQuedanPorVenderParaDarElPremio = cantidadDeBilletesQueQuedanPorVenderParaDarElPremio - 1;

                if (cantidadDeBilletesQueQuedanPorVenderParaDarElPremio == 0) {
                    System.out.println("¡Tiene un Discuento de " + precioBillete / 10 + " Euros para compras!");
                    cantidadDeBilletesQueQuedanPorVenderParaDarElPremio = 3;
                }
            }
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
            }
        }
        else {
            System.out.println("Error: NO SE PUEDE IMPRIMIR MÁS BILLETES");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }

    /**
     * vaciar dinero
     */
    public int vaciarDineroDeLaMaquina(){
        int totalDineroExtraido = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0) {
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("Error: ");
            totalDineroExtraido = -1;
        }

        return totalDineroExtraido;
    }

    public int getNumeroBilletesVendidos() {
        return numeroDeBilletesVendidos;
    }

    public void imprimeBilletesVendidos () {
        System.out.println ("Número de billetes vendidos: "+ numeroDeBilletesVendidos);
    }
}