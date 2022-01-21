import React from 'react';
import './index.css';

class Square extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            value: null
        };
    }

    render() {
        return (
            <button
                className="square"
                onClick={async () => {
                    console.log('click')
                    this.setState({value: 'X'})
                    var response;
                    var xhttp = new XMLHttpRequest();
                    xhttp.open("GET", "http://localhost:8080/printMessage")
                    xhttp.responseType = 'text';
                    xhttp.onload = function() {
                        response = xhttp.response
                        debugger
                        console.log('onload function ' + xhttp.response)
                    }
                    xhttp.send()
                    //const fetchResponse = await fetch('http://localhost:8080/printMessage', { mode: "no-cors"} )
                    debugger
                    console.log(response)
                    //console.log(fetchResponse)
                }}
            >
                {this.state.value}
                {this.props.value}
            </button>
        );
    }
}

class Board extends React.Component {
    renderSquare(i) {
        return <Square value={i} />;
    }

    render() {
        const status = 'Next player: X';

        return (
            <div>
                <div className="status">{status}</div>
                <div className="board-row">
                    {this.renderSquare(0)}
                    {this.renderSquare(1)}
                    {this.renderSquare(2)}
                </div>
                <div className="board-row">
                    {this.renderSquare(3)}
                    {this.renderSquare(4)}
                    {this.renderSquare(5)}
                </div>
                <div className="board-row">
                    {this.renderSquare(6)}
                    {this.renderSquare(7)}
                    {this.renderSquare(8)}
                </div>
            </div>
        );
    }
}

export class Game extends React.Component {
    render() {
        return (
            <div className="game">
                <div className="game-board">
                    <Board />
                </div>
                <div className="game-info">
                    <div>{/* status */}</div>
                    <ol>{/* TODO */}</ol>
                </div>
            </div>
        );
    }
}