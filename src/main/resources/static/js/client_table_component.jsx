var ClientTableComponent = React.createClass({

    getInitialState: function() {
        return {
            clients: []
        }
    },

    componentDidMount: function() {
        axios.get('http://localhost:8080/api/clients')
            .then(res => {
                const clients = res.data;
                this.setState({clients});
            });
    },

    removeClient: function(event) {
      console.log(event.target.value);
        axios.delete('http://localhost:8080/api/clients/' + 1, {
        }).then(result => window.location = "#/");
        console.log(response.data);
    },

    render: function () {
        return (
          <div>
              <h2>Table Of All Registered Clients</h2>
              <table className="table">
                  <thead>
                      <tr>
                          <th>First Name</th>
                          <th>Last Name</th>
                          <th>Date Of Birth</th>
                          <th>Phone Number</th>
                          <th>Client Type</th>
                          <th>Inventory count</th>
                          <th>Client account</th>
                          <th>Action</th>
                      </tr>
                  </thead>
                  <tbody>
                  {this.state.clients.map(client =>
                      <tr key={client.id}>
                          <td>{client.firstName}</td>
                          <td>{client.lastName}</td>
                          <td>{client.dateOfBirth}</td>
                          <td>{client.phoneNumber}</td>
                          <td>{client.clientType}</td>
                          <td>TODO</td>
                          <td>TODO</td>
                          <td value={client.id} onClick={this.removeClient}>remove</td>
                      </tr>
                  )}
                  </tbody>
              </table>
          </div>

        );
    }
});

window.ClientTableComponent = ClientTableComponent;
