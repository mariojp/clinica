package br.com.med.clinica.administrativo.model;

public class Usuários {
	   
       private String Nome;
       private String RG;
       private String CPF;

       

      public void setNome(String Nome){
          this.Nome = Nome;
      }


      public String getNome(){
          return this.Nome;
      }

     public void setRG(String RG){
         this.RG = RG;
     }

     public String getRG(){
        return this.RG;
     }
     
    public void setCPF(String CPF){
         this.CPF = CPF;
    }

    
   public String getCPF(){
       return this.CPF;
   }
}
