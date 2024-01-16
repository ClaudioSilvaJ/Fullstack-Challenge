
const Table = ({data}) => {
  console.log(data)

  return (
    <>
      <div>
        <table className="border-collapse border text-start">
          <thead>
            <tr>
              <th></th>
              <th className="border px-6 py-2">First Name</th>
              <th className="border px-6 py-2">Last Name</th>
              <th className="border px-6 py-2">Participation</th>
            </tr>
          </thead>
          <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td className="border px-6 py-1">{index+1}</td>
              <td className="border px-6 py-1">{item.firstName}</td>
              <td className="border px-6 py-1">{item.lastName}</td>
              <td className="border px-6 py-1">{item.participation}</td>
            </tr>
          ))}
          </tbody>

        </table>
      </div>

    </>
  )

}

export default Table;