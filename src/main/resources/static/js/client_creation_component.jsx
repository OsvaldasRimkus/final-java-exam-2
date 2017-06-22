var ClientCreationComponent = React.createClass({

    getInitialState: function() {
        return {firstName: '', lastName: '', dateOfBirth: '', phoneNumber: '', clientType: ''};
    },

    handleFirstNameChange: function(event) {
        this.setState({firstName: event.target.value})
    },

    handleLastNameChange: function(event) {
        this.setState({lastName: event.target.value})
    },

    handleDateOfBirthChange: function(event) {
      this.setState({dateOfBirth: event.target.value})
    },

    handlePhoneNumberChange: function(event) {
        this.setState({phoneNumber: event.target.value})
    },

    handleClientTypeChange: function(event) {
      this.setState({clientType: event.target.value})
    },

    registerClient: function() {
        axios.post('http://localhost:8080/api/clients', {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            dateOfBirth: this.state.dateOfBirth,
            phoneNumber: this.state.phoneNumber,
            clientType: this.state.clientType
        }).then(result => window.location = "#/");
        console.log(response.data);
    },

    goHome: function() {
      window.location = "#/";
    },

    render() {
        return (
            <div>
                <h2>Client Creation Form</h2>
                <button onClick={this.goHome}> home</button>
                <form>
                    <fieldset>
                        <legend>Register a client</legend>
                        <div className="form-group">
                            <label htmlFor="firstName">First Name</label>
                            <input className="form-control" id="firstName" name="firstName" value={this.props.firstName} onChange={this.handleFirstNameChange}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="lastName">Last Name</label>
                            <input className="form-control" id="lastName" name="lastName" value={this.props.lastName} onChange={this.handleLastNameChange}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="dateOfBirth">Date Of Birth</label>
                            <input className="form-control" id="dateOfBirth" name="dateOfBirth" value={this.props.dateOfBirth} onChange={this.handleDateOfBirthChange}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="phoneNumber">Phone Number</label>
                            <input className="form-control" id="phoneNumber" name="phoneNumber" value={this.props.phoneNumber} onChange={this.handlePhoneNumberChange}/>
                        </div>
                        <select onChange={this.handleClientTypeChange}>
                            <option >Choose client type</option>
                            <option value="Regular">Regular</option>
                            <option value="VIP">VIP</option>
                        </select>
                        <div className="form-group">
                            <input className="btn btn-primary" id="registerBtn" type="button" value="Register" onClick={this.registerClient}/>
                        </div>
                    </fieldset>
                </form>
            </div>
        )
    }

});

window.ClientCreationComponent = ClientCreationComponent;
