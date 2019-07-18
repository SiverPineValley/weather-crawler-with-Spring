import React , {Component} from 'react';

class Cities extends Component {


    componentDidMount() {
        const API = "http://localhost:8082/weather-crawler/available-cities"
        const req = new Request(API, {
            method: "GET",
            headers: new Headers({
              "Accept": "application/json",
            })
          });

        fetch(req)
        .then(data => data.json())
        .then(result => {
            this.setState({
                cities : result
            });
        });
    }

    render() {
        const {cities} = this.state;
        return (
            <div>
                List: {cities.map(item => {
                    return (<li>{item}</li>)
                })}
            </div>
            )
    }

}

export default Cities;