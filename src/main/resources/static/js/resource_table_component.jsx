var ResourceTableComponent = React.createClass({

    getInitialState: function() {
        return {
            resources: []
        }
    },

    componentDidMount: function() {
        axios.get('http://localhost:8080/api/resources')
            .then(res => {
                const resources = res.data;
                this.setState({resources});
            });
    },



    render: function () {
        return (
          <div>
              <h2>Table Of All Registered resources</h2>
              <table className="table">
                  <thead>
                      <tr>
                          <th>Title</th>
                          <th>Weight</th>
                          <th>Resource keeping sector</th>
                          <th>Start date of keeping</th>
                      </tr>
                  </thead>
                  <tbody>
                  {this.state.resources.map(resource =>
                      <tr key={resource.id}>
                          <td>{resource.firstName}</td>
                          <td>{resource.lastName}</td>
                          <td>{resource.dateOfBirth}</td>
                          <td>{resource.phoneNumber}</td>
                          <td>{resource.resourceType}</td>
                          <td>TODO</td>
                          <td>TODO</td>
                          <td value={resource.id} onClick={this.removeresource}>remove</td>
                      </tr>
                  )}
                  </tbody>
              </table>
          </div>

        );
    }
});

window.ResourceTableComponent = ResourceTableComponent;
