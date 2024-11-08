#include <stdlib.h>
#include <stdio.h>

int main() {
    int clientes, tiempo_llegada, tiempo_servicio;
    int tiempo_espera_total = 0;
    int tiempo_llegada_cliente = 0;
    int tiempo_inicio_servicio = 0;
    int tiempo_fin_servicio = 0;
    int tiempo_espera;  // Declarada fuera del bucle

    printf("Ingrese la cantidad de clientes en la cola: ");
    scanf("%d", &clientes);

    printf("Ingrese el tiempo promedio de llegada entre clientes (en minutos): ");
    scanf("%d", &tiempo_llegada);

    printf("Ingrese el tiempo promedio de servicio por cliente (en minutos): ");
    scanf("%d", &tiempo_servicio);

    printf("\nSimulación de la cola:\n");

    int i;
    for (i = 1; i <= clientes; i++) {
        tiempo_llegada_cliente += tiempo_llegada;

        if (tiempo_llegada_cliente > tiempo_fin_servicio) {
            tiempo_inicio_servicio = tiempo_llegada_cliente;
        } else {
            tiempo_inicio_servicio = tiempo_fin_servicio;
        }

        tiempo_fin_servicio = tiempo_inicio_servicio + tiempo_servicio;
        tiempo_espera = tiempo_inicio_servicio - tiempo_llegada_cliente;
        if (tiempo_espera < 0) {
            tiempo_espera = 0;
        }

        tiempo_espera_total += tiempo_espera;

        printf("Cliente %d - Tiempo de llegada: %d min, Tiempo de inicio de servicio: %d min, Tiempo de fin de servicio: %d min, Tiempo de espera: %d min\n", 
               i, tiempo_llegada_cliente, tiempo_inicio_servicio, tiempo_fin_servicio, tiempo_espera);
    }

    printf("\nTiempo de espera total para %d clientes: %d minutos\n", clientes, tiempo_espera_total);
    
    system("pause");
    system("cls");
    return 0;
}
