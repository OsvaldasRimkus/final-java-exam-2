const {Router, Route, hashHistory} = ReactRouter;

var App = React.createClass({
    render: function () {
        return (
            <div>
                <nav className="navbar navbar-inverse bg-inverse">
                    <a className="navbar-brand" href="#/">View Clients</a>
                    <a className="navbar-brand" href="#/createClient">Create Client</a>
                    <a className="navbar-brand" href="#/createResource">Create Resource</a>
                    <a className="navbar-brand" href="#/allResources">View Resources</a>
                </nav>

                <Router history={hashHistory}>
                    <Route path="/" component={ClientTableComponent} />
                    <Route path="/createClient" component={ClientCreationComponent} />
                    <Route path="/createResource" component={ResourceCreationComponent} />
                    <Route path="/allResources" component={ResourceTableComponent} />
                </Router>
            </div>
        );
    }
});

ReactDOM.render(<App />, document.getElementById('root'));
