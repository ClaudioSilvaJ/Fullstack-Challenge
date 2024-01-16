import axios from "axios";

const Header = () => {

  function handleSubmit(event) {
    event.preventDefault();
    const data = new FormData(event.target);
    const send = {
      firstName: data.get('firtname'),
      lastName: data.get('lastname'),
      participation: data.get('participation')
    }

    axios.post('http://localhost:8231/api/register', send)
      .then(response => {
        alert("Enviado com sucesso");
        setTimeout(() => {
          window.location.reload();
        }, 250);
      })
      .catch(error => {
        console.error("Erro ao enviar:", error);
      });
  }


  return (
    <>
      <div className="flex flex-row top-0 w-full h-28 justify-center items-center bg-blue-400">
          <form onSubmit={handleSubmit}>
            <input name="firtname" className="h-10 mx-4 px-2" placeholder="First name"/>
            <input name="lastname" className="h-10 mx-4 px-2" placeholder="Last name"/>
            <input name="participation" className="h-10 mx-4 px-2" placeholder="Participation"/>
            <button className="h-10 mx-4 w-32 border-2 text-white hover:bg-blue-500 active:bg-blue-600" type="submit">SEND</button>
          </form>
      </div>
    </>

  )

}

export default Header;