package br.com.lucasmartins.notepadapi.component;

import br.com.lucasmartins.notepadapi.model.Nota;
import br.com.lucasmartins.notepadapi.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NotaComponent {

    @Autowired
    NotaRepository notaRepository;


    public void salvar(Nota nota){
        List<Nota> notas = notaRepository.findByTitulo(nota.getTitulo());
        if(!notas.isEmpty()){
            nota.setId(notas.get(0).getId());
        }
        notaRepository.save(nota);
    }

    public Nota buscarNota(String titulo){
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if(notas.isEmpty()){
            return new Nota();
        }else{
            return notas.get(0);
        }
    }

    public List<Nota> buscarTodos(){
        return notaRepository.findAll();
    }


    public void apagar(String titulo){
        Nota nota;
        List<Nota> notas = notaRepository.findByTitulo(titulo);
        if(!notas.isEmpty()){
            notaRepository.delete((notas.get(0)));
        }
    }

    public void apagarTodos(){
        notaRepository.deleteAll();
    }
}
