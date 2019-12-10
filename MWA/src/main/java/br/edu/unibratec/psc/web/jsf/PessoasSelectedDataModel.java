package br.edu.unibratec.psc.web.jsf;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import br.edu.unibratec.psc.model.entity.Pessoa;

public class PessoasSelectedDataModel extends ListDataModel<Pessoa> implements SelectableDataModel<Pessoa> {
	
	public PessoasSelectedDataModel() {
		super();
	}
	
	public PessoasSelectedDataModel(List<Pessoa> pListaPessoas) {
		super(pListaPessoas);
	}
	
	public Pessoa getRowData(String pRowKey) {
		List<Pessoa> listaPessoas = (List<Pessoa>) getWrappedData();
		
		for ( Pessoa pessoa: listaPessoas ) {
			if ( pessoa.getCdMatricula() == Integer.parseInt(pRowKey) ) {
				return pessoa;
			}
		}
		
		return null;
	}
	
	public Object getRowKey(Pessoa pPessoa) {
		return pPessoa.getCdMatricula();
	}
	
}
