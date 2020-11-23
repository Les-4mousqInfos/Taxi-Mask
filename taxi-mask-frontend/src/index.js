function component() {
    const element = document.createElement('div');
    const config = require('./../build/webpack.base.conf.js');
  
    // Lodash, currently included via a script, is required for this line to work
    element.innerHTML = _.join('config/index.js');
  
    return element;
  }
  
  document.body.appendChild(component());