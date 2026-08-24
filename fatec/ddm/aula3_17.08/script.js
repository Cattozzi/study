function obterDadosUsuario(nomeUsuario){
    const url = `https://pokeapi.co/api/v2/pokemon/${nomeUsuario}`;
    
    return fetch(url)
    .then(function(response){
        if(response.ok){
            return response.json();
        } else {
            throw new Error("Erro ao obter dados do usuario. Cheque o nome do pokemon");
        }
    })
    .then(function(dados){
        return dados;
    })
    .catch(function(erro){
        console.log("Error: " + erro);
    });
}

obterDadosUsuario('pikachu')
.then(function(usuario){
    if (usuario) {
        exibirDadosdoUsuario(usuario);
    }
});

function exibirDadosdoUsuario(usuario){
    const tableBody = document.querySelector("#dados-table tbody");

    const row = document.createElement('tr');
    const nomeCell = document.createElement('td');
    const statsCell = document.createElement('td');
    const abilityCell = document.createElement('td');

   
    nomeCell.textContent = usuario.name;

    const listaStats = usuario.stats.map(function(item) {
        return item.stat.name + " (" + item.base_stat + ")";
    });
    statsCell.textContent = listaStats.join(', '); 

    const listaHabilidades = usuario.abilities.map(function(item) {
        return item.ability.name;
    });
    abilityCell.textContent = listaHabilidades.join(', '); 

    row.appendChild(nomeCell);
    row.appendChild(statsCell);
    row.appendChild(abilityCell);

    tableBody.appendChild(row);
}