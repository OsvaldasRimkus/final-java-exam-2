var ResourceCreationComponent = React.createClass({

    getInitialState: function() {
        return {resourceTitle: '', resourceWeight: '', resourceKeepingSector: 'N/A', dateOfKeepingStart: 'N/A'};
    },

    handleTitleChange: function(event) {
        this.setState({resourceTitle: event.target.value})
    },

    handleWeightChange: function(event) {
        this.setState({resourceWeight: event.target.value})
    },

    registerResource: function() {
        axios.post('http://localhost:8080/api/resources', {
            resourceTitle: this.state.resourceTitle,
            resourceWeight: this.state.resourceWeight,
            resourceKeepingSector: this.state.resourceKeepingSector,
            dateOfKeepingStart: this.state.dateOfKeepingStart
        }).then(result => window.location = "#/allResources");

    },

    goHome: function() {
      window.location = "#/allResources";
    },

    render() {
        return (
            <div>
                <h2>Resource Creation Form</h2>
                <button onClick={this.goHome}> home</button>
                <form>
                    <fieldset>
                        <legend>Register new resource</legend>
                        <div className="form-group">
                            <label htmlFor="title">Title</label>
                            <input className="form-control" id="title" name="title" value={this.props.resourceTitle} onChange={this.handleTitleChange}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="weight">Weight</label>
                            <input className="form-control" id="weight" name="weight" value={this.props.resourceWeight} onChange={this.handleWeightChange}/>
                        </div>
                        <div className="form-group">
                            <input className="btn btn-primary" id="registerBtn" type="button" value="Register" onClick={this.registerResource}/>
                        </div>
                    </fieldset>
                </form>
            </div>
        )
    }

});

window.ResourceCreationComponent = ResourceCreationComponent;
