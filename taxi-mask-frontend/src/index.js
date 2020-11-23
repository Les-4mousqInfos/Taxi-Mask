function component() {
    const element = document.createElement('div');
    element.innerHTML = _.join('config/index.js');
    //element.innerHTML = _.join('build/webpack.base.conf.js');
    // Lodash, currently included via a script, is required for this line to work
    
  
    return element;
  }
  
  document.body.appendChild(component());