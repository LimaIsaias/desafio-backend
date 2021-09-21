package br.com.limaisaias.desafioBackend.validations;

import br.com.limaisaias.desafioBackend.model.Model;
import lombok.Getter;

@Getter
public enum SchemaLocations {
        TERMINAL("classpath:schema/terminal-schema.json", new Model());

        private String schema;
        private Model model;


    SchemaLocations(String s, Model model) {
        this.model = model;
        this.schema = s;

    }
}
