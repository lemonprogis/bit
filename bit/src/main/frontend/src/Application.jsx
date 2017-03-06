"use strict";

import React from 'react';
import $ from 'jquery';

require('!style!css!less!./Application.less');

export class Application extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: 'Initial',
            counter: -1,
            when: ''
        };
    }
    fetchState() {
        $.ajax('/api/people').done((data) => this.setState(data));
    }
    render() {
        return (
            <div className="app-hello-message">
                Hello!
            </div>
        );
    }
    componentDidMount() {
        //this.interval = window.setInterval(this.fetchState.bind(this), 1000);
    }
    componentWillUnmount() {
        clearInterval(this.interval);
    }
}