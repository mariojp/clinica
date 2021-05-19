package br.com.med.clinica.administrativo.model;

public class Funcionarios {
	   public class Funcionario extends Usuários{
		     
	         public int NumCarTrabalho;
	         public String Login;
	         public String Senha;
	         

	         public void setNumCarTrabalho(int Value){
	         }
	  
	     public String getLogin() {
				return Login;
			}





			public void setLogin(String login) {
				Login = login;
			}





			public String getSenha() {
				return Senha;
			}





			public void setSenha(String senha) {
				Senha = senha;
			}





			public int getNumCarTrabalho() {
				return NumCarTrabalho;
			}





		@Override


	     public void setRG(String RG){
	          if(!RG.equals("")){
	              super.setRG(RG);
	          }
	     }

	    @Override
	    public String getRG(){
	         return super.getRG();
	   }
	   }
}
