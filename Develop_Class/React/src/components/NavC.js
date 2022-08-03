import { Component } from "react";

class NavC extends Component {
    render(){
        console.log("#NavC render()");
        var lists = [];
        var data = this.props.data;
        for(var i=0; i<data.length; i++){
            lists.push(<li key={data[i].id}>
                <a 
                    href={"/content/"+data[i].id}
                    onClick={function(id, e){
                        console.log("#NavC id", id);
                        e.preventDefault();
                        this.props.onChangePage(id);
                    }.bind(this, data[i].id)}>
                    {data[i].title}
                </a>
            </li>);
        }
        return(
            <nav>
            <ul>
                {lists}
            </ul>
            </nav>
        );
    }
  }
  export default NavC