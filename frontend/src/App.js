import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
  state = {
    rooms: []
  };

  async componentDidMount() {
    const response = await fetch('/api/rooms');
    const body = await response.json();
    this.setState({rooms: body});
  }

  render() {
    const {rooms} = this.state;
    return (
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <div className="App-intro">
              <h2>Rooms</h2>
              {rooms.map(room =>
                  <div key={room.id}>
                    {room.number}
                  </div>
              )}
            </div>
          </header>
        </div>
    );
  }
}
export default App;