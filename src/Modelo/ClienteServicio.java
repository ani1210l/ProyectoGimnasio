
package Modelo;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class ClienteServicio extends Cliente{
private int cli_serv_cod,Servicio_cod,Cod_cliente;
private Date servcli_fechaingreso,servcli_fechafin;

    public ClienteServicio() {
    }

    public int getCli_serv_cod() {
        return cli_serv_cod;
    }

    public void setCli_serv_cod(int cli_serv_cod) {
        this.cli_serv_cod = cli_serv_cod;
    }

    public int getServicio_cod() {
        return Servicio_cod;
    }

    public void setServicio_cod(int Servicio_cod) {
        this.Servicio_cod = Servicio_cod;
    }

    public int getCod_cliente() {
        return Cod_cliente;
    }

    public void setCod_cliente(int Cod_cliente) {
        this.Cod_cliente = Cod_cliente;
    }

    public Date getServcli_fechaingreso() {
        return servcli_fechaingreso;
    }

    public void setServcli_fechaingreso(Date servcli_fechaingreso) {
        this.servcli_fechaingreso = servcli_fechaingreso;
    }

    public Date getServcli_fechafin() {
        return servcli_fechafin;
    }

    public void setServcli_fechafin(Date servcli_fechafin) {
        this.servcli_fechafin = servcli_fechafin;
    }
        
  
   
    
    
}
